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
import com.repackage.a52;
import com.repackage.ap1;
import com.repackage.aq1;
import com.repackage.ar1;
import com.repackage.as1;
import com.repackage.at1;
import com.repackage.bq1;
import com.repackage.br1;
import com.repackage.bs1;
import com.repackage.cd3;
import com.repackage.ce2;
import com.repackage.cp1;
import com.repackage.cq1;
import com.repackage.cs1;
import com.repackage.dp1;
import com.repackage.dq1;
import com.repackage.dr1;
import com.repackage.ds1;
import com.repackage.e53;
import com.repackage.er1;
import com.repackage.es1;
import com.repackage.f43;
import com.repackage.fp1;
import com.repackage.fs1;
import com.repackage.g32;
import com.repackage.gp1;
import com.repackage.gq1;
import com.repackage.gr1;
import com.repackage.gs1;
import com.repackage.hp1;
import com.repackage.hr1;
import com.repackage.hs1;
import com.repackage.hw2;
import com.repackage.ip1;
import com.repackage.ir1;
import com.repackage.is1;
import com.repackage.jp1;
import com.repackage.jr1;
import com.repackage.kr1;
import com.repackage.ks1;
import com.repackage.lp1;
import com.repackage.lr1;
import com.repackage.mq1;
import com.repackage.mr1;
import com.repackage.mt2;
import com.repackage.np1;
import com.repackage.nq1;
import com.repackage.nr1;
import com.repackage.op1;
import com.repackage.or1;
import com.repackage.pb3;
import com.repackage.po1;
import com.repackage.pr1;
import com.repackage.qh1;
import com.repackage.qq2;
import com.repackage.rp1;
import com.repackage.rq1;
import com.repackage.s32;
import com.repackage.sq1;
import com.repackage.sq2;
import com.repackage.sr1;
import com.repackage.tp1;
import com.repackage.tq1;
import com.repackage.up1;
import com.repackage.uq1;
import com.repackage.ur1;
import com.repackage.vp1;
import com.repackage.vq1;
import com.repackage.w73;
import com.repackage.wp1;
import com.repackage.wt2;
import com.repackage.xp1;
import com.repackage.xq1;
import com.repackage.xs1;
import com.repackage.yp1;
import com.repackage.yq1;
import com.repackage.ys1;
import com.repackage.zp1;
import com.repackage.zr1;
import com.repackage.zs1;
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

    public static Map<String, Object> getV8ApiModules(final ap1 ap1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ap1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    gp1 gp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("1930258908", gp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(gp1Var, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Account.checkSession")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = gp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    hp1 hp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof hp1)) {
                            hp1Var = (hp1) obj;
                        } else {
                            hp1Var = new hp1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", hp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(hp1Var, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Account.getLoginCode")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 C = hp1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("1754780133", ip1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ip1Var, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Account.getOpenId")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = ip1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    po1 po1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof po1)) {
                            po1Var = (po1) obj;
                        } else {
                            po1Var = new po1(this.mSwanApiContext);
                            this.mApis.put("-343998465", po1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(po1Var, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Account.getUnionBDUSS")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = po1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    fp1 fp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof fp1)) {
                            fp1Var = (fp1) obj;
                        } else {
                            fp1Var = new fp1(this.mSwanApiContext);
                            this.mApis.put("-337742792", fp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(fp1Var, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Account.isBaiduAccountSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = fp1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    hp1 hp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof hp1)) {
                            hp1Var = (hp1) obj;
                        } else {
                            hp1Var = new hp1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", hp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(hp1Var, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Account.isLoginSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 H = hp1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    hp1 hp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof hp1)) {
                            hp1Var = (hp1) obj;
                        } else {
                            hp1Var = new hp1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", hp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(hp1Var, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Account.login")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 I = hp1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", jp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(jp1Var, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Basic.loadSubPackage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 F = jp1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", jp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(jp1Var, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Basic.loadSubPackages")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 G = jp1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    qh1 qh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof qh1)) {
                            qh1Var = (qh1) obj;
                        } else {
                            qh1Var = new qh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", qh1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(qh1Var, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Bookshelf.deleteBookshelf")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 K = qh1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    qh1 qh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof qh1)) {
                            qh1Var = (qh1) obj;
                        } else {
                            qh1Var = new qh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", qh1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(qh1Var, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Bookshelf.insertBookshelf")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 P = qh1Var.P(str);
                        return P == null ? "" : P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    qh1 qh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof qh1)) {
                            qh1Var = (qh1) obj;
                        } else {
                            qh1Var = new qh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", qh1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(qh1Var, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Bookshelf.navigateToBookshelf")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 U = qh1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    qh1 qh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof qh1)) {
                            qh1Var = (qh1) obj;
                        } else {
                            qh1Var = new qh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", qh1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(qh1Var, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Bookshelf.queryBookshelf")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 V = qh1Var.V(str);
                        return V == null ? "" : V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    qh1 qh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof qh1)) {
                            qh1Var = (qh1) obj;
                        } else {
                            qh1Var = new qh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", qh1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(qh1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Bookshelf.updateBookshelfReadTime")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 X = qh1Var.X(str);
                        return X == null ? "" : X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    dp1 dp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof dp1)) {
                            dp1Var = (dp1) obj;
                        } else {
                            dp1Var = new dp1(this.mSwanApiContext);
                            this.mApis.put("-277316359", dp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(dp1Var, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Coupon.getPlatformCoupons")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = dp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    dp1 dp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof dp1)) {
                            dp1Var = (dp1) obj;
                        } else {
                            dp1Var = new dp1(this.mSwanApiContext);
                            this.mApis.put("-277316359", dp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(dp1Var, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Coupon.getUserCoupons")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 z = dp1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    dp1 dp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof dp1)) {
                            dp1Var = (dp1) obj;
                        } else {
                            dp1Var = new dp1(this.mSwanApiContext);
                            this.mApis.put("-277316359", dp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(dp1Var, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Coupon.takeCoupons")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 C = dp1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    lp1 lp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof lp1)) {
                            lp1Var = (lp1) obj;
                        } else {
                            lp1Var = new lp1(this.mSwanApiContext);
                            this.mApis.put("-1225406515", lp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(lp1Var, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Favorite.getFavorStatus")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = lp1Var.x(str);
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
                        Pair<Boolean, ys1> a = at1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Favorite.showFavoriteGuide")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 G = showFavoriteGuideApi.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    np1 np1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof np1)) {
                            np1Var = (np1) obj;
                        } else {
                            np1Var = new np1(this.mSwanApiContext);
                            this.mApis.put("-2057135077", np1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(np1Var, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "File.shareFile")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = np1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    ce2 ce2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof ce2)) {
                            ce2Var = (ce2) obj;
                        } else {
                            ce2Var = new ce2(this.mSwanApiContext);
                            this.mApis.put("2077414795", ce2Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ce2Var, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = ce2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    ce2 ce2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof ce2)) {
                            ce2Var = (ce2) obj;
                        } else {
                            ce2Var = new ce2(this.mSwanApiContext);
                            this.mApis.put("2077414795", ce2Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ce2Var, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessageSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = ce2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String download(String str) {
                    op1 op1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof op1)) {
                            op1Var = (op1) obj;
                        } else {
                            op1Var = new op1(this.mSwanApiContext);
                            this.mApis.put("-170124576", op1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(op1Var, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "HostDownloadManager.download")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = op1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    op1 op1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof op1)) {
                            op1Var = (op1) obj;
                        } else {
                            op1Var = new op1(this.mSwanApiContext);
                            this.mApis.put("-170124576", op1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(op1Var, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "HostDownloadManager.openDownloadCenter")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = op1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    op1 op1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof op1)) {
                            op1Var = (op1) obj;
                        } else {
                            op1Var = new op1(this.mSwanApiContext);
                            this.mApis.put("-170124576", op1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(op1Var, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "HostDownloadManager.openFile")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 z = op1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    op1 op1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof op1)) {
                            op1Var = (op1) obj;
                        } else {
                            op1Var = new op1(this.mSwanApiContext);
                            this.mApis.put("-170124576", op1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(op1Var, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "HostDownloadManager.query")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 query = op1Var.query(str);
                        return query == null ? "" : query.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naImage", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    qq2 qq2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof qq2)) {
                            qq2Var = (qq2) obj;
                        } else {
                            qq2Var = new qq2(this.mSwanApiContext);
                            this.mApis.put("1445003743", qq2Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(qq2Var, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Image.callImageMenu")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = qq2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    rp1 rp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof rp1)) {
                            rp1Var = (rp1) obj;
                        } else {
                            rp1Var = new rp1(this.mSwanApiContext);
                            this.mApis.put("-1252730367", rp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(rp1Var, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Image.compressImage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = rp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    zp1 zp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof zp1)) {
                            zp1Var = (zp1) obj;
                        } else {
                            zp1Var = new zp1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", zp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(zp1Var, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.closeTabBar")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = zp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    zp1 zp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof zp1)) {
                            zp1Var = (zp1) obj;
                        } else {
                            zp1Var = new zp1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", zp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(zp1Var, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.closeTabBarRedDot")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = zp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    tp1 tp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("5236036", tp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(tp1Var, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.hideLoading")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = tp1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    vp1 vp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof vp1)) {
                            vp1Var = (vp1) obj;
                        } else {
                            vp1Var = new vp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", vp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(vp1Var, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.hideNavigationBarLoading")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = vp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    aq1 aq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof aq1)) {
                            aq1Var = (aq1) obj;
                        } else {
                            aq1Var = new aq1(this.mSwanApiContext);
                            this.mApis.put("1159492510", aq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(aq1Var, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.hideToast")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 K = aq1Var.K();
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    xp1 xp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof xp1)) {
                            xp1Var = (xp1) obj;
                        } else {
                            xp1Var = new xp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", xp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(xp1Var, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.openMultiPicker")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 G = xp1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    xp1 xp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof xp1)) {
                            xp1Var = (xp1) obj;
                        } else {
                            xp1Var = new xp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", xp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(xp1Var, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.openPicker")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 H = xp1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    zp1 zp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof zp1)) {
                            zp1Var = (zp1) obj;
                        } else {
                            zp1Var = new zp1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", zp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(zp1Var, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.openTabBar")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 C = zp1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    wp1 wp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof wp1)) {
                            wp1Var = (wp1) obj;
                        } else {
                            wp1Var = new wp1(this.mSwanApiContext);
                            this.mApis.put("-1750613704", wp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(wp1Var, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.pageScrollTo")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = wp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    vp1 vp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof vp1)) {
                            vp1Var = (vp1) obj;
                        } else {
                            vp1Var = new vp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", vp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(vp1Var, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarColor")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 z = vp1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    vp1 vp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof vp1)) {
                            vp1Var = (vp1) obj;
                        } else {
                            vp1Var = new vp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", vp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(vp1Var, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarTitle")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = vp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    zp1 zp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof zp1)) {
                            zp1Var = (zp1) obj;
                        } else {
                            zp1Var = new zp1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", zp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(zp1Var, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.setTabBarItem")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 D = zp1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    xp1 xp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof xp1)) {
                            xp1Var = (xp1) obj;
                        } else {
                            xp1Var = new xp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", xp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(xp1Var, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.showDatePickerView")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 L = xp1Var.L(str);
                        return L == null ? "" : L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    bq1 bq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof bq1)) {
                            bq1Var = (bq1) obj;
                        } else {
                            bq1Var = new bq1(this.mSwanApiContext);
                            this.mApis.put("1172469410", bq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(bq1Var, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.showHalfScreenWebview")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 K = bq1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    tp1 tp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("5236036", tp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(tp1Var, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.showLoading")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = tp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    up1 up1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("1913747800", up1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(up1Var, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.showModal")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = up1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    vp1 vp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof vp1)) {
                            vp1Var = (vp1) obj;
                        } else {
                            vp1Var = new vp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", vp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(vp1Var, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.showNavigationBarLoading")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 B = vp1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    aq1 aq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof aq1)) {
                            aq1Var = (aq1) obj;
                        } else {
                            aq1Var = new aq1(this.mSwanApiContext);
                            this.mApis.put("1159492510", aq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(aq1Var, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.showToast")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 Q = aq1Var.Q(str);
                        return Q == null ? "" : Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    yp1 yp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof yp1)) {
                            yp1Var = (yp1) obj;
                        } else {
                            yp1Var = new yp1(this.mSwanApiContext);
                            this.mApis.put("1165118609", yp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(yp1Var, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.stopPullDownRefresh")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = yp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    xp1 xp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof xp1)) {
                            xp1Var = (xp1) obj;
                        } else {
                            xp1Var = new xp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", xp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(xp1Var, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.updateMultiPicker")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 M = xp1Var.M(str);
                        return M == null ? "" : M.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    cq1 cq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof cq1)) {
                            cq1Var = (cq1) obj;
                        } else {
                            cq1Var = new cq1(this.mSwanApiContext);
                            this.mApis.put("-137346255", cq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(cq1Var, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Keyboard.startKeyboardHeightChange")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 C = cq1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    cq1 cq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof cq1)) {
                            cq1Var = (cq1) obj;
                        } else {
                            cq1Var = new cq1(this.mSwanApiContext);
                            this.mApis.put("-137346255", cq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(cq1Var, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Keyboard.stopKeyboardHeightChange")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 D = cq1Var.D();
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    dq1 dq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof dq1)) {
                            dq1Var = (dq1) obj;
                        } else {
                            dq1Var = new dq1(this.mSwanApiContext);
                            this.mApis.put("-397373095", dq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(dq1Var, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "LocationService.getLocation")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = dq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    dq1 dq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof dq1)) {
                            dq1Var = (dq1) obj;
                        } else {
                            dq1Var = new dq1(this.mSwanApiContext);
                            this.mApis.put("-397373095", dq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(dq1Var, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "LocationService.startLocationUpdate")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = dq1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    dq1 dq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof dq1)) {
                            dq1Var = (dq1) obj;
                        } else {
                            dq1Var = new dq1(this.mSwanApiContext);
                            this.mApis.put("-397373095", dq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(dq1Var, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "LocationService.stopLocationUpdate")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 B = dq1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    ur1 ur1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof ur1)) {
                            ur1Var = (ur1) obj;
                        } else {
                            ur1Var = new ur1(this.mSwanApiContext);
                            this.mApis.put("538070032", ur1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ur1Var, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = ur1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String callService(String str) {
                    gq1 gq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof gq1)) {
                            gq1Var = (gq1) obj;
                        } else {
                            gq1Var = new gq1(this.mSwanApiContext);
                            this.mApis.put("-1076509454", gq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(gq1Var, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Network.callService")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = gq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    nq1 nq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof nq1)) {
                            nq1Var = (nq1) obj;
                        } else {
                            nq1Var = new nq1(this.mSwanApiContext);
                            this.mApis.put("968563034", nq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(nq1Var, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Network.cancelRequest")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 D = nq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    mq1 mq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof mq1)) {
                            mq1Var = (mq1) obj;
                        } else {
                            mq1Var = new mq1(this.mSwanApiContext);
                            this.mApis.put("453220699", mq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(mq1Var, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Network.getNetworkType")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = mq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    mq1 mq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof mq1)) {
                            mq1Var = (mq1) obj;
                        } else {
                            mq1Var = new mq1(this.mSwanApiContext);
                            this.mApis.put("453220699", mq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(mq1Var, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Network.networkStatusChange")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = mq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                @JavascriptInterface
                public String request(JsObject jsObject) {
                    InterceptResult invokeL2;
                    nq1 nq1Var;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && (invokeL2 = interceptable2.invokeL(1048580, this, jsObject)) != null) {
                        return (String) invokeL2.objValue;
                    }
                    try {
                        xs1.c().a("request");
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof nq1)) {
                            nq1Var = (nq1) obj;
                        } else {
                            nq1Var = new nq1(this.mSwanApiContext);
                            this.mApis.put("968563034", nq1Var);
                        }
                        Pair<Boolean, ys1> a2 = at1.a(nq1Var, "swanAPI/request");
                        if (((Boolean) a2.first).booleanValue()) {
                            a = ((ys1) a2.second).a();
                        } else if (g32.a(this.mSwanApiContext.e(), "Network.request")) {
                            a = new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        } else {
                            Pair<ys1, JSONObject> t = cp1.t(jsObject);
                            if (!((ys1) t.first).isSuccess()) {
                                a = ((ys1) t.first).a();
                            } else {
                                JSONObject jSONObject = (JSONObject) t.second;
                                if (jSONObject == null) {
                                    a = ys1.a.a();
                                } else {
                                    zs1 V = nq1Var.V(jSONObject);
                                    a = V == null ? "" : V.a();
                                }
                            }
                        }
                        return a;
                    } finally {
                    }
                }
            });
            hashMap.put("_naPayment", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    wt2 wt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof wt2)) {
                            wt2Var = (wt2) obj;
                        } else {
                            wt2Var = new wt2(this.mSwanApiContext);
                            this.mApis.put("-336396851", wt2Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(wt2Var, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Payment.chooseCoupon")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = wt2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    wt2 wt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof wt2)) {
                            wt2Var = (wt2) obj;
                        } else {
                            wt2Var = new wt2(this.mSwanApiContext);
                            this.mApis.put("-336396851", wt2Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(wt2Var, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Payment.getPaymentInfo")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = wt2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    mt2 mt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof mt2)) {
                            mt2Var = (mt2) obj;
                        } else {
                            mt2Var = new mt2(this.mSwanApiContext);
                            this.mApis.put("1854689529", mt2Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(mt2Var, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Payment.requestThirdPayment")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = mt2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    wt2 wt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof wt2)) {
                            wt2Var = (wt2) obj;
                        } else {
                            wt2Var = new wt2(this.mSwanApiContext);
                            this.mApis.put("-336396851", wt2Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(wt2Var, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Payment.setPaymentInfo")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 z = wt2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    hw2 hw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof hw2)) {
                            hw2Var = (hw2) obj;
                        } else {
                            hw2Var = new hw2(this.mSwanApiContext);
                            this.mApis.put("-254510461", hw2Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(hw2Var, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Plugin.invokePluginChooseAddress")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = hw2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    hw2 hw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof hw2)) {
                            hw2Var = (hw2) obj;
                        } else {
                            hw2Var = new hw2(this.mSwanApiContext);
                            this.mApis.put("-254510461", hw2Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(hw2Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 z = hw2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    hw2 hw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof hw2)) {
                            hw2Var = (hw2) obj;
                        } else {
                            hw2Var = new hw2(this.mSwanApiContext);
                            this.mApis.put("-254510461", hw2Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(hw2Var, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Plugin.invokePluginPayment")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = hw2Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    a52 a52Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof a52)) {
                            a52Var = (a52) obj;
                        } else {
                            a52Var = new a52(this.mSwanApiContext);
                            this.mApis.put("-2068479848", a52Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(a52Var, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Prefetch.prefetchResources")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = a52Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    s32 s32Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof s32)) {
                            s32Var = (s32) obj;
                        } else {
                            s32Var = new s32(this.mSwanApiContext);
                            this.mApis.put("423661539", s32Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(s32Var, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Preload.preloadStatus")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = s32Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    cd3 cd3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof cd3)) {
                            cd3Var = (cd3) obj;
                        } else {
                            cd3Var = new cd3(this.mSwanApiContext);
                            this.mApis.put("-1929343869", cd3Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(cd3Var, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "PrivateFile.uploadFileToBos")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 C = cd3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    rq1 rq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof rq1)) {
                            rq1Var = (rq1) obj;
                        } else {
                            rq1Var = new rq1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", rq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(rq1Var, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Router.hideModalPage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = rq1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    rq1 rq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof rq1)) {
                            rq1Var = (rq1) obj;
                        } else {
                            rq1Var = new rq1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", rq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(rq1Var, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Router.navigateBack")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 B = rq1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    sq1 sq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof sq1)) {
                            sq1Var = (sq1) obj;
                        } else {
                            sq1Var = new sq1(this.mSwanApiContext);
                            this.mApis.put("1968522584", sq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(sq1Var, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Router.navigateTo")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 H = sq1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    uq1 uq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof uq1)) {
                            uq1Var = (uq1) obj;
                        } else {
                            uq1Var = new uq1(this.mSwanApiContext);
                            this.mApis.put("1317280190", uq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(uq1Var, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Router.reLaunch")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = uq1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    vq1 vq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("-420075743", vq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(vq1Var, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Router.reLoadErrorPage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = vq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    tq1 tq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof tq1)) {
                            tq1Var = (tq1) obj;
                        } else {
                            tq1Var = new tq1(this.mSwanApiContext);
                            this.mApis.put("1792515533", tq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(tq1Var, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Router.redirectTo")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 D = tq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    sq1 sq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof sq1)) {
                            sq1Var = (sq1) obj;
                        } else {
                            sq1Var = new sq1(this.mSwanApiContext);
                            this.mApis.put("1968522584", sq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(sq1Var, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Router.showModalPage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 J = sq1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    yq1 yq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof yq1)) {
                            yq1Var = (yq1) obj;
                        } else {
                            yq1Var = new yq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", yq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(yq1Var, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Setting.getAppInfoSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 F = yq1Var.F();
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    yq1 yq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof yq1)) {
                            yq1Var = (yq1) obj;
                        } else {
                            yq1Var = new yq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", yq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(yq1Var, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Setting.getSetting")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 G = yq1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    yq1 yq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof yq1)) {
                            yq1Var = (yq1) obj;
                        } else {
                            yq1Var = new yq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", yq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(yq1Var, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Setting.getSlaveIdSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 H = yq1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    yq1 yq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof yq1)) {
                            yq1Var = (yq1) obj;
                        } else {
                            yq1Var = new yq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", yq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(yq1Var, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Setting.getSwanId")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 I = yq1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    yq1 yq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof yq1)) {
                            yq1Var = (yq1) obj;
                        } else {
                            yq1Var = new yq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", yq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(yq1Var, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Setting.getUserInfo")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 J = yq1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    xq1 xq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof xq1)) {
                            xq1Var = (xq1) obj;
                        } else {
                            xq1Var = new xq1(this.mSwanApiContext);
                            this.mApis.put("450273045", xq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(xq1Var, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Setting.isAllowedAdOpenAppSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = xq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    w73 w73Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof w73)) {
                            w73Var = (w73) obj;
                        } else {
                            w73Var = new w73(this.mSwanApiContext);
                            this.mApis.put("712777136", w73Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(w73Var, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = w73Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    br1 br1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-804054859", br1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(br1Var, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = br1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    br1 br1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-804054859", br1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(br1Var, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorageSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 C = br1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    ar1 ar1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ar1)) {
                            ar1Var = (ar1) obj;
                        } else {
                            ar1Var = new ar1(this.mSwanApiContext);
                            this.mApis.put("130910081", ar1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ar1Var, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.clearStorage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = ar1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    ar1 ar1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ar1)) {
                            ar1Var = (ar1) obj;
                        } else {
                            ar1Var = new ar1(this.mSwanApiContext);
                            this.mApis.put("130910081", ar1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ar1Var, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.clearStorageSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 C = ar1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-804054859", br1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(br1Var, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.getGlobalStorage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 D = br1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    br1 br1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-804054859", br1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(br1Var, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfo")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 G = br1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    br1 br1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-804054859", br1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(br1Var, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfoSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 J = br1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-804054859", br1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(br1Var, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 K = br1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    ar1 ar1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ar1)) {
                            ar1Var = (ar1) obj;
                        } else {
                            ar1Var = new ar1(this.mSwanApiContext);
                            this.mApis.put("130910081", ar1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ar1Var, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.getStorage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 D = ar1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    ar1 ar1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ar1)) {
                            ar1Var = (ar1) obj;
                        } else {
                            ar1Var = new ar1(this.mSwanApiContext);
                            this.mApis.put("130910081", ar1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ar1Var, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.getStorageInfo")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 G = ar1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    ar1 ar1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ar1)) {
                            ar1Var = (ar1) obj;
                        } else {
                            ar1Var = new ar1(this.mSwanApiContext);
                            this.mApis.put("130910081", ar1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ar1Var, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.getStorageInfoAsync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 H = ar1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    ar1 ar1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ar1)) {
                            ar1Var = (ar1) obj;
                        } else {
                            ar1Var = new ar1(this.mSwanApiContext);
                            this.mApis.put("130910081", ar1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ar1Var, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.getStorageInfoSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 J = ar1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    ar1 ar1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ar1)) {
                            ar1Var = (ar1) obj;
                        } else {
                            ar1Var = new ar1(this.mSwanApiContext);
                            this.mApis.put("130910081", ar1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ar1Var, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.getStorageSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 K = ar1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-804054859", br1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(br1Var, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 R = br1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-804054859", br1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(br1Var, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorageSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 T = br1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    ar1 ar1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ar1)) {
                            ar1Var = (ar1) obj;
                        } else {
                            ar1Var = new ar1(this.mSwanApiContext);
                            this.mApis.put("130910081", ar1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ar1Var, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.removeStorage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 R = ar1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    ar1 ar1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ar1)) {
                            ar1Var = (ar1) obj;
                        } else {
                            ar1Var = new ar1(this.mSwanApiContext);
                            this.mApis.put("130910081", ar1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ar1Var, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.removeStorageSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 T = ar1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-804054859", br1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(br1Var, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.setGlobalStorage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 U = br1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-804054859", br1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(br1Var, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.setGlobalStorageSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 W = br1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    ar1 ar1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ar1)) {
                            ar1Var = (ar1) obj;
                        } else {
                            ar1Var = new ar1(this.mSwanApiContext);
                            this.mApis.put("130910081", ar1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ar1Var, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.setStorage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 U = ar1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    ar1 ar1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ar1)) {
                            ar1Var = (ar1) obj;
                        } else {
                            ar1Var = new ar1(this.mSwanApiContext);
                            this.mApis.put("130910081", ar1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ar1Var, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.setStorageSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 W = ar1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    dr1 dr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof dr1)) {
                            dr1Var = (dr1) obj;
                        } else {
                            dr1Var = new dr1(this.mSwanApiContext);
                            this.mApis.put("823117982", dr1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(dr1Var, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Subscription.requestSubscribeFormId")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 E = dr1Var.E(str);
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    er1 er1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof er1)) {
                            er1Var = (er1) obj;
                        } else {
                            er1Var = new er1(this.mSwanApiContext);
                            this.mApis.put("-947445811", er1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(er1Var, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Subscription.subscribeService")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 F = er1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    lr1 lr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof lr1)) {
                            lr1Var = (lr1) obj;
                        } else {
                            lr1Var = new lr1(this.mSwanApiContext);
                            this.mApis.put("1936205521", lr1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(lr1Var, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.exitFullScreen")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = lr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    hr1 hr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof hr1)) {
                            hr1Var = (hr1) obj;
                        } else {
                            hr1Var = new hr1(this.mSwanApiContext);
                            this.mApis.put("99997465", hr1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(hr1Var, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.getBrightness")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = hr1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    ir1 ir1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof ir1)) {
                            ir1Var = (ir1) obj;
                        } else {
                            ir1Var = new ir1(this.mSwanApiContext);
                            this.mApis.put("-518757484", ir1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ir1Var, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.getClipboardData")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = ir1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    kr1 kr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof kr1)) {
                            kr1Var = (kr1) obj;
                        } else {
                            kr1Var = new kr1(this.mSwanApiContext);
                            this.mApis.put("1694151270", kr1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(kr1Var, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.getDeviceInfo")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = kr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    mr1 mr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof mr1)) {
                            mr1Var = (mr1) obj;
                        } else {
                            mr1Var = new mr1(this.mSwanApiContext);
                            this.mApis.put("-1321681619", mr1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(mr1Var, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.getDeviceProfile")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = mr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    sr1 sr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof sr1)) {
                            sr1Var = (sr1) obj;
                        } else {
                            sr1Var = new sr1(this.mSwanApiContext);
                            this.mApis.put("447234992", sr1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(sr1Var, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.getMediaVolume")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = sr1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    nr1 nr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof nr1)) {
                            nr1Var = (nr1) obj;
                        } else {
                            nr1Var = new nr1(this.mSwanApiContext);
                            this.mApis.put("-1569246082", nr1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(nr1Var, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.makePhoneCall")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = nr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    pr1 pr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof pr1)) {
                            pr1Var = (pr1) obj;
                        } else {
                            pr1Var = new pr1(this.mSwanApiContext);
                            this.mApis.put("1099851202", pr1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(pr1Var, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.openSMSPanel")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = pr1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    or1 or1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof or1)) {
                            or1Var = (or1) obj;
                        } else {
                            or1Var = new or1(this.mSwanApiContext);
                            this.mApis.put("-1707203360", or1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(or1Var, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.requestFullScreen")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 F = or1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    ir1 ir1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof ir1)) {
                            ir1Var = (ir1) obj;
                        } else {
                            ir1Var = new ir1(this.mSwanApiContext);
                            this.mApis.put("-518757484", ir1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ir1Var, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.setClipboardData")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = ir1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    sq2 sq2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof sq2)) {
                            sq2Var = (sq2) obj;
                        } else {
                            sq2Var = new sq2(this.mSwanApiContext);
                            this.mApis.put("1161486049", sq2Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(sq2Var, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.setErrorPageType")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = sq2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    sr1 sr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof sr1)) {
                            sr1Var = (sr1) obj;
                        } else {
                            sr1Var = new sr1(this.mSwanApiContext);
                            this.mApis.put("447234992", sr1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(sr1Var, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.setMediaVolume")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 z = sr1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    gr1 gr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof gr1)) {
                            gr1Var = (gr1) obj;
                        } else {
                            gr1Var = new gr1(this.mSwanApiContext);
                            this.mApis.put("1372680763", gr1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(gr1Var, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.startAccelerometer")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = gr1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    jr1 jr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof jr1)) {
                            jr1Var = (jr1) obj;
                        } else {
                            jr1Var = new jr1(this.mSwanApiContext);
                            this.mApis.put("1689255576", jr1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(jr1Var, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.startCompass")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = jr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    gr1 gr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof gr1)) {
                            gr1Var = (gr1) obj;
                        } else {
                            gr1Var = new gr1(this.mSwanApiContext);
                            this.mApis.put("1372680763", gr1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(gr1Var, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.stopAccelerometer")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 B = gr1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    jr1 jr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof jr1)) {
                            jr1Var = (jr1) obj;
                        } else {
                            jr1Var = new jr1(this.mSwanApiContext);
                            this.mApis.put("1689255576", jr1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(jr1Var, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.stopCompass")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 z = jr1Var.z();
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    ds1 ds1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof ds1)) {
                            ds1Var = (ds1) obj;
                        } else {
                            ds1Var = new ds1(this.mSwanApiContext);
                            this.mApis.put("201194468", ds1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ds1Var, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.addToDesktop")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 B = ds1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    zr1 zr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof zr1)) {
                            zr1Var = (zr1) obj;
                        } else {
                            zr1Var = new zr1(this.mSwanApiContext);
                            this.mApis.put("-1412306947", zr1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(zr1Var, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.calcMD5")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = zr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    as1 as1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof as1)) {
                            as1Var = (as1) obj;
                        } else {
                            as1Var = new as1(this.mSwanApiContext);
                            this.mApis.put("1626415364", as1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(as1Var, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.checkAppInstalled")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = as1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    cs1 cs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof cs1)) {
                            cs1Var = (cs1) obj;
                        } else {
                            cs1Var = new cs1(this.mSwanApiContext);
                            this.mApis.put("-836768778", cs1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(cs1Var, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfo")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = cs1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    is1 is1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof is1)) {
                            is1Var = (is1) obj;
                        } else {
                            is1Var = new is1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", is1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(is1Var, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfoSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 E = is1Var.E();
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    es1 es1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof es1)) {
                            es1Var = (es1) obj;
                        } else {
                            es1Var = new es1(this.mSwanApiContext);
                            this.mApis.put("-810858308", es1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(es1Var, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.getPerformanceLevel")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = es1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    is1 is1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof is1)) {
                            is1Var = (is1) obj;
                        } else {
                            is1Var = new is1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", is1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(is1Var, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.getSystemInfo")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 H = is1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    is1 is1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof is1)) {
                            is1Var = (is1) obj;
                        } else {
                            is1Var = new is1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", is1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(is1Var, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.getSystemInfoAsync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 I = is1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    is1 is1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof is1)) {
                            is1Var = (is1) obj;
                        } else {
                            is1Var = new is1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", is1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(is1Var, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.getSystemInfoSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 J = is1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    fs1 fs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof fs1)) {
                            fs1Var = (fs1) obj;
                        } else {
                            fs1Var = new fs1(this.mSwanApiContext);
                            this.mApis.put("-2097727681", fs1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(fs1Var, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.handleException")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = fs1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    bs1 bs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof bs1)) {
                            bs1Var = (bs1) obj;
                        } else {
                            bs1Var = new bs1(this.mSwanApiContext);
                            this.mApis.put("2084449317", bs1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(bs1Var, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.hasCloseHandler")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = bs1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    e53 e53Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof e53)) {
                            e53Var = (e53) obj;
                        } else {
                            e53Var = new e53(this.mSwanApiContext);
                            this.mApis.put("1031678042", e53Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(e53Var, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.hideCaptureScreenShareDialog")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = e53Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    gs1 gs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof gs1)) {
                            gs1Var = (gs1) obj;
                        } else {
                            gs1Var = new gs1(this.mSwanApiContext);
                            this.mApis.put("1751900130", gs1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(gs1Var, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.logToFile")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = gs1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    f43 f43Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof f43)) {
                            f43Var = (f43) obj;
                        } else {
                            f43Var = new f43(this.mSwanApiContext);
                            this.mApis.put("1748196865", f43Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(f43Var, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.preloadPackage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = f43Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    hs1 hs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof hs1)) {
                            hs1Var = (hs1) obj;
                        } else {
                            hs1Var = new hs1(this.mSwanApiContext);
                            this.mApis.put("589529211", hs1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(hs1Var, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.previewImage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 B = hs1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    ks1 ks1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof ks1)) {
                            ks1Var = (ks1) obj;
                        } else {
                            ks1Var = new ks1(this.mSwanApiContext);
                            this.mApis.put("-577481801", ks1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ks1Var, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.ubcFlowJar")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 I = ks1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    pb3 pb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof pb3)) {
                            pb3Var = (pb3) obj;
                        } else {
                            pb3Var = new pb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", pb3Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(pb3Var, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Wifi.connectWifi")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = pb3Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    pb3 pb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof pb3)) {
                            pb3Var = (pb3) obj;
                        } else {
                            pb3Var = new pb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", pb3Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(pb3Var, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Wifi.getConnectedWifi")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 B = pb3Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    pb3 pb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof pb3)) {
                            pb3Var = (pb3) obj;
                        } else {
                            pb3Var = new pb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", pb3Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(pb3Var, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Wifi.getWifiList")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 C = pb3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    pb3 pb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof pb3)) {
                            pb3Var = (pb3) obj;
                        } else {
                            pb3Var = new pb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", pb3Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(pb3Var, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Wifi.startWifi")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 G = pb3Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    pb3 pb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof pb3)) {
                            pb3Var = (pb3) obj;
                        } else {
                            pb3Var = new pb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", pb3Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(pb3Var, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Wifi.stopWifi")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 H = pb3Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static Map<String, Object> getWebviewApiModules(final ap1 ap1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ap1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    gp1 gp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof gp1)) {
                            gp1Var = (gp1) obj;
                        } else {
                            gp1Var = new gp1(this.mSwanApiContext);
                            this.mApis.put("1930258908", gp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(gp1Var, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Account.checkSession")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = gp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    hp1 hp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof hp1)) {
                            hp1Var = (hp1) obj;
                        } else {
                            hp1Var = new hp1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", hp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(hp1Var, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Account.getLoginCode")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 C = hp1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    ip1 ip1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof ip1)) {
                            ip1Var = (ip1) obj;
                        } else {
                            ip1Var = new ip1(this.mSwanApiContext);
                            this.mApis.put("1754780133", ip1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ip1Var, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Account.getOpenId")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = ip1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    po1 po1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof po1)) {
                            po1Var = (po1) obj;
                        } else {
                            po1Var = new po1(this.mSwanApiContext);
                            this.mApis.put("-343998465", po1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(po1Var, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Account.getUnionBDUSS")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = po1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    fp1 fp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof fp1)) {
                            fp1Var = (fp1) obj;
                        } else {
                            fp1Var = new fp1(this.mSwanApiContext);
                            this.mApis.put("-337742792", fp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(fp1Var, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Account.isBaiduAccountSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = fp1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    hp1 hp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof hp1)) {
                            hp1Var = (hp1) obj;
                        } else {
                            hp1Var = new hp1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", hp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(hp1Var, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Account.isLoginSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 H = hp1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    hp1 hp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof hp1)) {
                            hp1Var = (hp1) obj;
                        } else {
                            hp1Var = new hp1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", hp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(hp1Var, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Account.login")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 I = hp1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", jp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(jp1Var, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Basic.loadSubPackage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 F = jp1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    jp1 jp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof jp1)) {
                            jp1Var = (jp1) obj;
                        } else {
                            jp1Var = new jp1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", jp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(jp1Var, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Basic.loadSubPackages")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 G = jp1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    qh1 qh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof qh1)) {
                            qh1Var = (qh1) obj;
                        } else {
                            qh1Var = new qh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", qh1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(qh1Var, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Bookshelf.deleteBookshelf")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 K = qh1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    qh1 qh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof qh1)) {
                            qh1Var = (qh1) obj;
                        } else {
                            qh1Var = new qh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", qh1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(qh1Var, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Bookshelf.insertBookshelf")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 P = qh1Var.P(str);
                        return P == null ? "" : P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    qh1 qh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof qh1)) {
                            qh1Var = (qh1) obj;
                        } else {
                            qh1Var = new qh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", qh1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(qh1Var, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Bookshelf.navigateToBookshelf")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 U = qh1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    qh1 qh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof qh1)) {
                            qh1Var = (qh1) obj;
                        } else {
                            qh1Var = new qh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", qh1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(qh1Var, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Bookshelf.queryBookshelf")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 V = qh1Var.V(str);
                        return V == null ? "" : V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    qh1 qh1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof qh1)) {
                            qh1Var = (qh1) obj;
                        } else {
                            qh1Var = new qh1(this.mSwanApiContext);
                            this.mApis.put("1460300387", qh1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(qh1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Bookshelf.updateBookshelfReadTime")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 X = qh1Var.X(str);
                        return X == null ? "" : X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    dp1 dp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof dp1)) {
                            dp1Var = (dp1) obj;
                        } else {
                            dp1Var = new dp1(this.mSwanApiContext);
                            this.mApis.put("-277316359", dp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(dp1Var, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Coupon.getPlatformCoupons")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = dp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    dp1 dp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof dp1)) {
                            dp1Var = (dp1) obj;
                        } else {
                            dp1Var = new dp1(this.mSwanApiContext);
                            this.mApis.put("-277316359", dp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(dp1Var, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Coupon.getUserCoupons")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 z = dp1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    dp1 dp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof dp1)) {
                            dp1Var = (dp1) obj;
                        } else {
                            dp1Var = new dp1(this.mSwanApiContext);
                            this.mApis.put("-277316359", dp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(dp1Var, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Coupon.takeCoupons")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 C = dp1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    lp1 lp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof lp1)) {
                            lp1Var = (lp1) obj;
                        } else {
                            lp1Var = new lp1(this.mSwanApiContext);
                            this.mApis.put("-1225406515", lp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(lp1Var, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Favorite.getFavorStatus")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = lp1Var.x(str);
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
                        Pair<Boolean, ys1> a = at1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Favorite.showFavoriteGuide")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 G = showFavoriteGuideApi.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    np1 np1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof np1)) {
                            np1Var = (np1) obj;
                        } else {
                            np1Var = new np1(this.mSwanApiContext);
                            this.mApis.put("-2057135077", np1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(np1Var, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "File.shareFile")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = np1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    ce2 ce2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof ce2)) {
                            ce2Var = (ce2) obj;
                        } else {
                            ce2Var = new ce2(this.mSwanApiContext);
                            this.mApis.put("2077414795", ce2Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ce2Var, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = ce2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    ce2 ce2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof ce2)) {
                            ce2Var = (ce2) obj;
                        } else {
                            ce2Var = new ce2(this.mSwanApiContext);
                            this.mApis.put("2077414795", ce2Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ce2Var, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "GameCenter.postGameCenterMessageSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = ce2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String download(String str) {
                    op1 op1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof op1)) {
                            op1Var = (op1) obj;
                        } else {
                            op1Var = new op1(this.mSwanApiContext);
                            this.mApis.put("-170124576", op1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(op1Var, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "HostDownloadManager.download")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = op1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    op1 op1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof op1)) {
                            op1Var = (op1) obj;
                        } else {
                            op1Var = new op1(this.mSwanApiContext);
                            this.mApis.put("-170124576", op1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(op1Var, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "HostDownloadManager.openDownloadCenter")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = op1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    op1 op1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof op1)) {
                            op1Var = (op1) obj;
                        } else {
                            op1Var = new op1(this.mSwanApiContext);
                            this.mApis.put("-170124576", op1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(op1Var, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "HostDownloadManager.openFile")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 z = op1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    op1 op1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof op1)) {
                            op1Var = (op1) obj;
                        } else {
                            op1Var = new op1(this.mSwanApiContext);
                            this.mApis.put("-170124576", op1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(op1Var, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "HostDownloadManager.query")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 query = op1Var.query(str);
                        return query == null ? "" : query.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naImage", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    qq2 qq2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof qq2)) {
                            qq2Var = (qq2) obj;
                        } else {
                            qq2Var = new qq2(this.mSwanApiContext);
                            this.mApis.put("1445003743", qq2Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(qq2Var, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Image.callImageMenu")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = qq2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    rp1 rp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof rp1)) {
                            rp1Var = (rp1) obj;
                        } else {
                            rp1Var = new rp1(this.mSwanApiContext);
                            this.mApis.put("-1252730367", rp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(rp1Var, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Image.compressImage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = rp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    zp1 zp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof zp1)) {
                            zp1Var = (zp1) obj;
                        } else {
                            zp1Var = new zp1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", zp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(zp1Var, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.closeTabBar")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = zp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    zp1 zp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof zp1)) {
                            zp1Var = (zp1) obj;
                        } else {
                            zp1Var = new zp1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", zp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(zp1Var, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.closeTabBarRedDot")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = zp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    tp1 tp1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("5236036", tp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(tp1Var, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.hideLoading")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = tp1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    vp1 vp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof vp1)) {
                            vp1Var = (vp1) obj;
                        } else {
                            vp1Var = new vp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", vp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(vp1Var, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.hideNavigationBarLoading")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = vp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    aq1 aq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof aq1)) {
                            aq1Var = (aq1) obj;
                        } else {
                            aq1Var = new aq1(this.mSwanApiContext);
                            this.mApis.put("1159492510", aq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(aq1Var, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.hideToast")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 K = aq1Var.K();
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    xp1 xp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof xp1)) {
                            xp1Var = (xp1) obj;
                        } else {
                            xp1Var = new xp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", xp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(xp1Var, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.openMultiPicker")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 G = xp1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    xp1 xp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof xp1)) {
                            xp1Var = (xp1) obj;
                        } else {
                            xp1Var = new xp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", xp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(xp1Var, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.openPicker")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 H = xp1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    zp1 zp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof zp1)) {
                            zp1Var = (zp1) obj;
                        } else {
                            zp1Var = new zp1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", zp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(zp1Var, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.openTabBar")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 C = zp1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    wp1 wp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof wp1)) {
                            wp1Var = (wp1) obj;
                        } else {
                            wp1Var = new wp1(this.mSwanApiContext);
                            this.mApis.put("-1750613704", wp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(wp1Var, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.pageScrollTo")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = wp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    vp1 vp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof vp1)) {
                            vp1Var = (vp1) obj;
                        } else {
                            vp1Var = new vp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", vp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(vp1Var, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarColor")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 z = vp1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    vp1 vp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof vp1)) {
                            vp1Var = (vp1) obj;
                        } else {
                            vp1Var = new vp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", vp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(vp1Var, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.setNavigationBarTitle")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = vp1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    zp1 zp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof zp1)) {
                            zp1Var = (zp1) obj;
                        } else {
                            zp1Var = new zp1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", zp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(zp1Var, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.setTabBarItem")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 D = zp1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    xp1 xp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof xp1)) {
                            xp1Var = (xp1) obj;
                        } else {
                            xp1Var = new xp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", xp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(xp1Var, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.showDatePickerView")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 L = xp1Var.L(str);
                        return L == null ? "" : L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    bq1 bq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof bq1)) {
                            bq1Var = (bq1) obj;
                        } else {
                            bq1Var = new bq1(this.mSwanApiContext);
                            this.mApis.put("1172469410", bq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(bq1Var, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.showHalfScreenWebview")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 K = bq1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    tp1 tp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof tp1)) {
                            tp1Var = (tp1) obj;
                        } else {
                            tp1Var = new tp1(this.mSwanApiContext);
                            this.mApis.put("5236036", tp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(tp1Var, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.showLoading")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = tp1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    up1 up1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof up1)) {
                            up1Var = (up1) obj;
                        } else {
                            up1Var = new up1(this.mSwanApiContext);
                            this.mApis.put("1913747800", up1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(up1Var, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.showModal")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = up1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    vp1 vp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof vp1)) {
                            vp1Var = (vp1) obj;
                        } else {
                            vp1Var = new vp1(this.mSwanApiContext);
                            this.mApis.put("-246386074", vp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(vp1Var, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.showNavigationBarLoading")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 B = vp1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    aq1 aq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof aq1)) {
                            aq1Var = (aq1) obj;
                        } else {
                            aq1Var = new aq1(this.mSwanApiContext);
                            this.mApis.put("1159492510", aq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(aq1Var, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.showToast")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 Q = aq1Var.Q(str);
                        return Q == null ? "" : Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    yp1 yp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof yp1)) {
                            yp1Var = (yp1) obj;
                        } else {
                            yp1Var = new yp1(this.mSwanApiContext);
                            this.mApis.put("1165118609", yp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(yp1Var, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.stopPullDownRefresh")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = yp1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    xp1 xp1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof xp1)) {
                            xp1Var = (xp1) obj;
                        } else {
                            xp1Var = new xp1(this.mSwanApiContext);
                            this.mApis.put("-108978463", xp1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(xp1Var, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Interaction.updateMultiPicker")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 M = xp1Var.M(str);
                        return M == null ? "" : M.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    cq1 cq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof cq1)) {
                            cq1Var = (cq1) obj;
                        } else {
                            cq1Var = new cq1(this.mSwanApiContext);
                            this.mApis.put("-137346255", cq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(cq1Var, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Keyboard.startKeyboardHeightChange")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 C = cq1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    cq1 cq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof cq1)) {
                            cq1Var = (cq1) obj;
                        } else {
                            cq1Var = new cq1(this.mSwanApiContext);
                            this.mApis.put("-137346255", cq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(cq1Var, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Keyboard.stopKeyboardHeightChange")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 D = cq1Var.D();
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    dq1 dq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof dq1)) {
                            dq1Var = (dq1) obj;
                        } else {
                            dq1Var = new dq1(this.mSwanApiContext);
                            this.mApis.put("-397373095", dq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(dq1Var, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "LocationService.getLocation")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = dq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    dq1 dq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof dq1)) {
                            dq1Var = (dq1) obj;
                        } else {
                            dq1Var = new dq1(this.mSwanApiContext);
                            this.mApis.put("-397373095", dq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(dq1Var, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "LocationService.startLocationUpdate")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = dq1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    dq1 dq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof dq1)) {
                            dq1Var = (dq1) obj;
                        } else {
                            dq1Var = new dq1(this.mSwanApiContext);
                            this.mApis.put("-397373095", dq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(dq1Var, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "LocationService.stopLocationUpdate")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 B = dq1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    ur1 ur1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof ur1)) {
                            ur1Var = (ur1) obj;
                        } else {
                            ur1Var = new ur1(this.mSwanApiContext);
                            this.mApis.put("538070032", ur1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ur1Var, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = ur1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String callService(String str) {
                    gq1 gq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof gq1)) {
                            gq1Var = (gq1) obj;
                        } else {
                            gq1Var = new gq1(this.mSwanApiContext);
                            this.mApis.put("-1076509454", gq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(gq1Var, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Network.callService")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = gq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    nq1 nq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof nq1)) {
                            nq1Var = (nq1) obj;
                        } else {
                            nq1Var = new nq1(this.mSwanApiContext);
                            this.mApis.put("968563034", nq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(nq1Var, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Network.cancelRequest")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 D = nq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    mq1 mq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof mq1)) {
                            mq1Var = (mq1) obj;
                        } else {
                            mq1Var = new mq1(this.mSwanApiContext);
                            this.mApis.put("453220699", mq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(mq1Var, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Network.getNetworkType")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = mq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    mq1 mq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof mq1)) {
                            mq1Var = (mq1) obj;
                        } else {
                            mq1Var = new mq1(this.mSwanApiContext);
                            this.mApis.put("453220699", mq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(mq1Var, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Network.networkStatusChange")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = mq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                @JavascriptInterface
                public String request(String str) {
                    InterceptResult invokeL2;
                    nq1 nq1Var;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && (invokeL2 = interceptable2.invokeL(1048580, this, str)) != null) {
                        return (String) invokeL2.objValue;
                    }
                    try {
                        xs1.c().a("request");
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof nq1)) {
                            nq1Var = (nq1) obj;
                        } else {
                            nq1Var = new nq1(this.mSwanApiContext);
                            this.mApis.put("968563034", nq1Var);
                        }
                        Pair<Boolean, ys1> a2 = at1.a(nq1Var, "swanAPI/request");
                        if (((Boolean) a2.first).booleanValue()) {
                            a = ((ys1) a2.second).a();
                        } else if (g32.a(this.mSwanApiContext.e(), "Network.request")) {
                            a = new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        } else {
                            Pair<ys1, JSONObject> u = cp1.u(str);
                            if (!((ys1) u.first).isSuccess()) {
                                a = ((ys1) u.first).a();
                            } else {
                                JSONObject jSONObject = (JSONObject) u.second;
                                if (jSONObject == null) {
                                    a = ys1.a.a();
                                } else {
                                    zs1 V = nq1Var.V(jSONObject);
                                    a = V == null ? "" : V.a();
                                }
                            }
                        }
                        return a;
                    } finally {
                    }
                }
            });
            hashMap.put("_naPayment", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    wt2 wt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof wt2)) {
                            wt2Var = (wt2) obj;
                        } else {
                            wt2Var = new wt2(this.mSwanApiContext);
                            this.mApis.put("-336396851", wt2Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(wt2Var, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Payment.chooseCoupon")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = wt2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    wt2 wt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof wt2)) {
                            wt2Var = (wt2) obj;
                        } else {
                            wt2Var = new wt2(this.mSwanApiContext);
                            this.mApis.put("-336396851", wt2Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(wt2Var, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Payment.getPaymentInfo")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = wt2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    mt2 mt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof mt2)) {
                            mt2Var = (mt2) obj;
                        } else {
                            mt2Var = new mt2(this.mSwanApiContext);
                            this.mApis.put("1854689529", mt2Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(mt2Var, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Payment.requestThirdPayment")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = mt2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    wt2 wt2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof wt2)) {
                            wt2Var = (wt2) obj;
                        } else {
                            wt2Var = new wt2(this.mSwanApiContext);
                            this.mApis.put("-336396851", wt2Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(wt2Var, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Payment.setPaymentInfo")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 z = wt2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    hw2 hw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof hw2)) {
                            hw2Var = (hw2) obj;
                        } else {
                            hw2Var = new hw2(this.mSwanApiContext);
                            this.mApis.put("-254510461", hw2Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(hw2Var, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Plugin.invokePluginChooseAddress")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = hw2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    hw2 hw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof hw2)) {
                            hw2Var = (hw2) obj;
                        } else {
                            hw2Var = new hw2(this.mSwanApiContext);
                            this.mApis.put("-254510461", hw2Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(hw2Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 z = hw2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    hw2 hw2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof hw2)) {
                            hw2Var = (hw2) obj;
                        } else {
                            hw2Var = new hw2(this.mSwanApiContext);
                            this.mApis.put("-254510461", hw2Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(hw2Var, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Plugin.invokePluginPayment")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = hw2Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    a52 a52Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof a52)) {
                            a52Var = (a52) obj;
                        } else {
                            a52Var = new a52(this.mSwanApiContext);
                            this.mApis.put("-2068479848", a52Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(a52Var, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Prefetch.prefetchResources")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = a52Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    s32 s32Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof s32)) {
                            s32Var = (s32) obj;
                        } else {
                            s32Var = new s32(this.mSwanApiContext);
                            this.mApis.put("423661539", s32Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(s32Var, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Preload.preloadStatus")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = s32Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    cd3 cd3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof cd3)) {
                            cd3Var = (cd3) obj;
                        } else {
                            cd3Var = new cd3(this.mSwanApiContext);
                            this.mApis.put("-1929343869", cd3Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(cd3Var, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "PrivateFile.uploadFileToBos")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 C = cd3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    rq1 rq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof rq1)) {
                            rq1Var = (rq1) obj;
                        } else {
                            rq1Var = new rq1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", rq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(rq1Var, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Router.hideModalPage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = rq1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    rq1 rq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof rq1)) {
                            rq1Var = (rq1) obj;
                        } else {
                            rq1Var = new rq1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", rq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(rq1Var, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Router.navigateBack")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 B = rq1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    sq1 sq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof sq1)) {
                            sq1Var = (sq1) obj;
                        } else {
                            sq1Var = new sq1(this.mSwanApiContext);
                            this.mApis.put("1968522584", sq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(sq1Var, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Router.navigateTo")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 H = sq1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    uq1 uq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof uq1)) {
                            uq1Var = (uq1) obj;
                        } else {
                            uq1Var = new uq1(this.mSwanApiContext);
                            this.mApis.put("1317280190", uq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(uq1Var, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Router.reLaunch")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = uq1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    vq1 vq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof vq1)) {
                            vq1Var = (vq1) obj;
                        } else {
                            vq1Var = new vq1(this.mSwanApiContext);
                            this.mApis.put("-420075743", vq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(vq1Var, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Router.reLoadErrorPage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = vq1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    tq1 tq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof tq1)) {
                            tq1Var = (tq1) obj;
                        } else {
                            tq1Var = new tq1(this.mSwanApiContext);
                            this.mApis.put("1792515533", tq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(tq1Var, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Router.redirectTo")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 D = tq1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    sq1 sq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof sq1)) {
                            sq1Var = (sq1) obj;
                        } else {
                            sq1Var = new sq1(this.mSwanApiContext);
                            this.mApis.put("1968522584", sq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(sq1Var, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Router.showModalPage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 J = sq1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    yq1 yq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof yq1)) {
                            yq1Var = (yq1) obj;
                        } else {
                            yq1Var = new yq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", yq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(yq1Var, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Setting.getAppInfoSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 F = yq1Var.F();
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    yq1 yq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof yq1)) {
                            yq1Var = (yq1) obj;
                        } else {
                            yq1Var = new yq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", yq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(yq1Var, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Setting.getSetting")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 G = yq1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    yq1 yq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof yq1)) {
                            yq1Var = (yq1) obj;
                        } else {
                            yq1Var = new yq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", yq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(yq1Var, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Setting.getSlaveIdSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 H = yq1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    yq1 yq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof yq1)) {
                            yq1Var = (yq1) obj;
                        } else {
                            yq1Var = new yq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", yq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(yq1Var, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Setting.getSwanId")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 I = yq1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    yq1 yq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof yq1)) {
                            yq1Var = (yq1) obj;
                        } else {
                            yq1Var = new yq1(this.mSwanApiContext);
                            this.mApis.put("-594895721", yq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(yq1Var, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Setting.getUserInfo")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 J = yq1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    xq1 xq1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof xq1)) {
                            xq1Var = (xq1) obj;
                        } else {
                            xq1Var = new xq1(this.mSwanApiContext);
                            this.mApis.put("450273045", xq1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(xq1Var, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Setting.isAllowedAdOpenAppSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = xq1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    w73 w73Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof w73)) {
                            w73Var = (w73) obj;
                        } else {
                            w73Var = new w73(this.mSwanApiContext);
                            this.mApis.put("712777136", w73Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(w73Var, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = w73Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    br1 br1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-804054859", br1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(br1Var, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = br1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    br1 br1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-804054859", br1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(br1Var, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.clearGlobalStorageSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 C = br1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    ar1 ar1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ar1)) {
                            ar1Var = (ar1) obj;
                        } else {
                            ar1Var = new ar1(this.mSwanApiContext);
                            this.mApis.put("130910081", ar1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ar1Var, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.clearStorage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = ar1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    ar1 ar1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ar1)) {
                            ar1Var = (ar1) obj;
                        } else {
                            ar1Var = new ar1(this.mSwanApiContext);
                            this.mApis.put("130910081", ar1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ar1Var, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.clearStorageSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 C = ar1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-804054859", br1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(br1Var, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.getGlobalStorage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 D = br1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    br1 br1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-804054859", br1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(br1Var, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfo")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 G = br1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    br1 br1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-804054859", br1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(br1Var, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageInfoSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 J = br1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-804054859", br1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(br1Var, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.getGlobalStorageSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 K = br1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    ar1 ar1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ar1)) {
                            ar1Var = (ar1) obj;
                        } else {
                            ar1Var = new ar1(this.mSwanApiContext);
                            this.mApis.put("130910081", ar1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ar1Var, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.getStorage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 D = ar1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    ar1 ar1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ar1)) {
                            ar1Var = (ar1) obj;
                        } else {
                            ar1Var = new ar1(this.mSwanApiContext);
                            this.mApis.put("130910081", ar1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ar1Var, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.getStorageInfo")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 G = ar1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    ar1 ar1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ar1)) {
                            ar1Var = (ar1) obj;
                        } else {
                            ar1Var = new ar1(this.mSwanApiContext);
                            this.mApis.put("130910081", ar1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ar1Var, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.getStorageInfoAsync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 H = ar1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    ar1 ar1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ar1)) {
                            ar1Var = (ar1) obj;
                        } else {
                            ar1Var = new ar1(this.mSwanApiContext);
                            this.mApis.put("130910081", ar1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ar1Var, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.getStorageInfoSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 J = ar1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    ar1 ar1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ar1)) {
                            ar1Var = (ar1) obj;
                        } else {
                            ar1Var = new ar1(this.mSwanApiContext);
                            this.mApis.put("130910081", ar1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ar1Var, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.getStorageSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 K = ar1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-804054859", br1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(br1Var, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 R = br1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-804054859", br1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(br1Var, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.removeGlobalStorageSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 T = br1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    ar1 ar1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ar1)) {
                            ar1Var = (ar1) obj;
                        } else {
                            ar1Var = new ar1(this.mSwanApiContext);
                            this.mApis.put("130910081", ar1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ar1Var, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.removeStorage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 R = ar1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    ar1 ar1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ar1)) {
                            ar1Var = (ar1) obj;
                        } else {
                            ar1Var = new ar1(this.mSwanApiContext);
                            this.mApis.put("130910081", ar1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ar1Var, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.removeStorageSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 T = ar1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-804054859", br1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(br1Var, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.setGlobalStorage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 U = br1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    br1 br1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof br1)) {
                            br1Var = (br1) obj;
                        } else {
                            br1Var = new br1(this.mSwanApiContext);
                            this.mApis.put("-804054859", br1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(br1Var, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.setGlobalStorageSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 W = br1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    ar1 ar1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ar1)) {
                            ar1Var = (ar1) obj;
                        } else {
                            ar1Var = new ar1(this.mSwanApiContext);
                            this.mApis.put("130910081", ar1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ar1Var, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.setStorage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 U = ar1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    ar1 ar1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof ar1)) {
                            ar1Var = (ar1) obj;
                        } else {
                            ar1Var = new ar1(this.mSwanApiContext);
                            this.mApis.put("130910081", ar1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ar1Var, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Storage.setStorageSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 W = ar1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    dr1 dr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof dr1)) {
                            dr1Var = (dr1) obj;
                        } else {
                            dr1Var = new dr1(this.mSwanApiContext);
                            this.mApis.put("823117982", dr1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(dr1Var, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Subscription.requestSubscribeFormId")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 E = dr1Var.E(str);
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    er1 er1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof er1)) {
                            er1Var = (er1) obj;
                        } else {
                            er1Var = new er1(this.mSwanApiContext);
                            this.mApis.put("-947445811", er1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(er1Var, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Subscription.subscribeService")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 F = er1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    lr1 lr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof lr1)) {
                            lr1Var = (lr1) obj;
                        } else {
                            lr1Var = new lr1(this.mSwanApiContext);
                            this.mApis.put("1936205521", lr1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(lr1Var, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.exitFullScreen")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = lr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    hr1 hr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof hr1)) {
                            hr1Var = (hr1) obj;
                        } else {
                            hr1Var = new hr1(this.mSwanApiContext);
                            this.mApis.put("99997465", hr1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(hr1Var, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.getBrightness")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = hr1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    ir1 ir1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof ir1)) {
                            ir1Var = (ir1) obj;
                        } else {
                            ir1Var = new ir1(this.mSwanApiContext);
                            this.mApis.put("-518757484", ir1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ir1Var, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.getClipboardData")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = ir1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    kr1 kr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof kr1)) {
                            kr1Var = (kr1) obj;
                        } else {
                            kr1Var = new kr1(this.mSwanApiContext);
                            this.mApis.put("1694151270", kr1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(kr1Var, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.getDeviceInfo")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = kr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    mr1 mr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof mr1)) {
                            mr1Var = (mr1) obj;
                        } else {
                            mr1Var = new mr1(this.mSwanApiContext);
                            this.mApis.put("-1321681619", mr1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(mr1Var, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.getDeviceProfile")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = mr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    sr1 sr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof sr1)) {
                            sr1Var = (sr1) obj;
                        } else {
                            sr1Var = new sr1(this.mSwanApiContext);
                            this.mApis.put("447234992", sr1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(sr1Var, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.getMediaVolume")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = sr1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    nr1 nr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof nr1)) {
                            nr1Var = (nr1) obj;
                        } else {
                            nr1Var = new nr1(this.mSwanApiContext);
                            this.mApis.put("-1569246082", nr1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(nr1Var, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.makePhoneCall")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = nr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    pr1 pr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof pr1)) {
                            pr1Var = (pr1) obj;
                        } else {
                            pr1Var = new pr1(this.mSwanApiContext);
                            this.mApis.put("1099851202", pr1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(pr1Var, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.openSMSPanel")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = pr1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    or1 or1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof or1)) {
                            or1Var = (or1) obj;
                        } else {
                            or1Var = new or1(this.mSwanApiContext);
                            this.mApis.put("-1707203360", or1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(or1Var, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.requestFullScreen")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 F = or1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    ir1 ir1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof ir1)) {
                            ir1Var = (ir1) obj;
                        } else {
                            ir1Var = new ir1(this.mSwanApiContext);
                            this.mApis.put("-518757484", ir1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ir1Var, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.setClipboardData")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = ir1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    sq2 sq2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof sq2)) {
                            sq2Var = (sq2) obj;
                        } else {
                            sq2Var = new sq2(this.mSwanApiContext);
                            this.mApis.put("1161486049", sq2Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(sq2Var, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.setErrorPageType")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = sq2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    sr1 sr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof sr1)) {
                            sr1Var = (sr1) obj;
                        } else {
                            sr1Var = new sr1(this.mSwanApiContext);
                            this.mApis.put("447234992", sr1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(sr1Var, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.setMediaVolume")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 z = sr1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    gr1 gr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof gr1)) {
                            gr1Var = (gr1) obj;
                        } else {
                            gr1Var = new gr1(this.mSwanApiContext);
                            this.mApis.put("1372680763", gr1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(gr1Var, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.startAccelerometer")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = gr1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    jr1 jr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof jr1)) {
                            jr1Var = (jr1) obj;
                        } else {
                            jr1Var = new jr1(this.mSwanApiContext);
                            this.mApis.put("1689255576", jr1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(jr1Var, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.startCompass")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = jr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    gr1 gr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof gr1)) {
                            gr1Var = (gr1) obj;
                        } else {
                            gr1Var = new gr1(this.mSwanApiContext);
                            this.mApis.put("1372680763", gr1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(gr1Var, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.stopAccelerometer")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 B = gr1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    jr1 jr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof jr1)) {
                            jr1Var = (jr1) obj;
                        } else {
                            jr1Var = new jr1(this.mSwanApiContext);
                            this.mApis.put("1689255576", jr1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(jr1Var, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "System.stopCompass")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 z = jr1Var.z();
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    ds1 ds1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof ds1)) {
                            ds1Var = (ds1) obj;
                        } else {
                            ds1Var = new ds1(this.mSwanApiContext);
                            this.mApis.put("201194468", ds1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ds1Var, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.addToDesktop")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 B = ds1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    zr1 zr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof zr1)) {
                            zr1Var = (zr1) obj;
                        } else {
                            zr1Var = new zr1(this.mSwanApiContext);
                            this.mApis.put("-1412306947", zr1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(zr1Var, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.calcMD5")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = zr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    as1 as1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof as1)) {
                            as1Var = (as1) obj;
                        } else {
                            as1Var = new as1(this.mSwanApiContext);
                            this.mApis.put("1626415364", as1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(as1Var, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.checkAppInstalled")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = as1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    cs1 cs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof cs1)) {
                            cs1Var = (cs1) obj;
                        } else {
                            cs1Var = new cs1(this.mSwanApiContext);
                            this.mApis.put("-836768778", cs1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(cs1Var, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfo")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = cs1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    is1 is1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof is1)) {
                            is1Var = (is1) obj;
                        } else {
                            is1Var = new is1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", is1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(is1Var, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.getCommonSysInfoSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 E = is1Var.E();
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    es1 es1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof es1)) {
                            es1Var = (es1) obj;
                        } else {
                            es1Var = new es1(this.mSwanApiContext);
                            this.mApis.put("-810858308", es1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(es1Var, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.getPerformanceLevel")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = es1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    is1 is1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof is1)) {
                            is1Var = (is1) obj;
                        } else {
                            is1Var = new is1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", is1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(is1Var, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.getSystemInfo")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 H = is1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    is1 is1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof is1)) {
                            is1Var = (is1) obj;
                        } else {
                            is1Var = new is1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", is1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(is1Var, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.getSystemInfoAsync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 I = is1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    is1 is1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof is1)) {
                            is1Var = (is1) obj;
                        } else {
                            is1Var = new is1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", is1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(is1Var, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.getSystemInfoSync")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 J = is1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    fs1 fs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof fs1)) {
                            fs1Var = (fs1) obj;
                        } else {
                            fs1Var = new fs1(this.mSwanApiContext);
                            this.mApis.put("-2097727681", fs1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(fs1Var, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.handleException")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = fs1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    bs1 bs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof bs1)) {
                            bs1Var = (bs1) obj;
                        } else {
                            bs1Var = new bs1(this.mSwanApiContext);
                            this.mApis.put("2084449317", bs1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(bs1Var, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.hasCloseHandler")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = bs1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    e53 e53Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof e53)) {
                            e53Var = (e53) obj;
                        } else {
                            e53Var = new e53(this.mSwanApiContext);
                            this.mApis.put("1031678042", e53Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(e53Var, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.hideCaptureScreenShareDialog")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 x = e53Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    gs1 gs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof gs1)) {
                            gs1Var = (gs1) obj;
                        } else {
                            gs1Var = new gs1(this.mSwanApiContext);
                            this.mApis.put("1751900130", gs1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(gs1Var, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.logToFile")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 y = gs1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    f43 f43Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof f43)) {
                            f43Var = (f43) obj;
                        } else {
                            f43Var = new f43(this.mSwanApiContext);
                            this.mApis.put("1748196865", f43Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(f43Var, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.preloadPackage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = f43Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    hs1 hs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof hs1)) {
                            hs1Var = (hs1) obj;
                        } else {
                            hs1Var = new hs1(this.mSwanApiContext);
                            this.mApis.put("589529211", hs1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(hs1Var, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.previewImage")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 B = hs1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    ks1 ks1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof ks1)) {
                            ks1Var = (ks1) obj;
                        } else {
                            ks1Var = new ks1(this.mSwanApiContext);
                            this.mApis.put("-577481801", ks1Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(ks1Var, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Utils.ubcFlowJar")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 I = ks1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(ap1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ap1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ap1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = ap1Var;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    pb3 pb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof pb3)) {
                            pb3Var = (pb3) obj;
                        } else {
                            pb3Var = new pb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", pb3Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(pb3Var, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Wifi.connectWifi")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 A = pb3Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    pb3 pb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof pb3)) {
                            pb3Var = (pb3) obj;
                        } else {
                            pb3Var = new pb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", pb3Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(pb3Var, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Wifi.getConnectedWifi")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 B = pb3Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    pb3 pb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof pb3)) {
                            pb3Var = (pb3) obj;
                        } else {
                            pb3Var = new pb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", pb3Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(pb3Var, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Wifi.getWifiList")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 C = pb3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    pb3 pb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof pb3)) {
                            pb3Var = (pb3) obj;
                        } else {
                            pb3Var = new pb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", pb3Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(pb3Var, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Wifi.startWifi")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 G = pb3Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    pb3 pb3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof pb3)) {
                            pb3Var = (pb3) obj;
                        } else {
                            pb3Var = new pb3(this.mSwanApiContext);
                            this.mApis.put("1879401452", pb3Var);
                        }
                        Pair<Boolean, ys1> a = at1.a(pb3Var, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ys1) a.second).a();
                        }
                        if (g32.a(this.mSwanApiContext.e(), "Wifi.stopWifi")) {
                            return new zs1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        zs1 H = pb3Var.H(str);
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
