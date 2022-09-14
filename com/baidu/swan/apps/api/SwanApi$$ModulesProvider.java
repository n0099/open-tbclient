package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.tieba.as1;
import com.baidu.tieba.at1;
import com.baidu.tieba.au1;
import com.baidu.tieba.bf3;
import com.baidu.tieba.bg2;
import com.baidu.tieba.br1;
import com.baidu.tieba.bs1;
import com.baidu.tieba.bu1;
import com.baidu.tieba.cr1;
import com.baidu.tieba.cs1;
import com.baidu.tieba.ct1;
import com.baidu.tieba.cu1;
import com.baidu.tieba.d73;
import com.baidu.tieba.dt1;
import com.baidu.tieba.du1;
import com.baidu.tieba.e63;
import com.baidu.tieba.er1;
import com.baidu.tieba.eu1;
import com.baidu.tieba.f52;
import com.baidu.tieba.fr1;
import com.baidu.tieba.fs1;
import com.baidu.tieba.ft1;
import com.baidu.tieba.fu1;
import com.baidu.tieba.gr1;
import com.baidu.tieba.gt1;
import com.baidu.tieba.gu1;
import com.baidu.tieba.gy2;
import com.baidu.tieba.hr1;
import com.baidu.tieba.ht1;
import com.baidu.tieba.hu1;
import com.baidu.tieba.ir1;
import com.baidu.tieba.it1;
import com.baidu.tieba.jt1;
import com.baidu.tieba.ju1;
import com.baidu.tieba.kr1;
import com.baidu.tieba.kt1;
import com.baidu.tieba.ls1;
import com.baidu.tieba.lt1;
import com.baidu.tieba.lv2;
import com.baidu.tieba.mr1;
import com.baidu.tieba.ms1;
import com.baidu.tieba.mt1;
import com.baidu.tieba.nr1;
import com.baidu.tieba.nt1;
import com.baidu.tieba.od3;
import com.baidu.tieba.oq1;
import com.baidu.tieba.ot1;
import com.baidu.tieba.pj1;
import com.baidu.tieba.ps2;
import com.baidu.tieba.qr1;
import com.baidu.tieba.qs1;
import com.baidu.tieba.r52;
import com.baidu.tieba.rs1;
import com.baidu.tieba.rs2;
import com.baidu.tieba.rt1;
import com.baidu.tieba.sr1;
import com.baidu.tieba.ss1;
import com.baidu.tieba.tr1;
import com.baidu.tieba.ts1;
import com.baidu.tieba.tt1;
import com.baidu.tieba.ur1;
import com.baidu.tieba.us1;
import com.baidu.tieba.v93;
import com.baidu.tieba.vr1;
import com.baidu.tieba.vv2;
import com.baidu.tieba.wr1;
import com.baidu.tieba.ws1;
import com.baidu.tieba.wu1;
import com.baidu.tieba.xr1;
import com.baidu.tieba.xs1;
import com.baidu.tieba.xu1;
import com.baidu.tieba.yr1;
import com.baidu.tieba.yt1;
import com.baidu.tieba.yu1;
import com.baidu.tieba.z62;
import com.baidu.tieba.zq1;
import com.baidu.tieba.zr1;
import com.baidu.tieba.zs1;
import com.baidu.tieba.zt1;
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

    public static Map<String, Object> getV8ApiModules(final zq1 zq1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, zq1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    fr1 fr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof fr1)) {
                            fr1Var = (fr1) obj;
                        } else {
                            fr1Var = new fr1(this.mSwanApiContext);
                            this.mApis.put("1930258908", fr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(fr1Var, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Account.checkSession")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = fr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    gr1 gr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof gr1)) {
                            gr1Var = (gr1) obj;
                        } else {
                            gr1Var = new gr1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", gr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(gr1Var, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Account.getLoginCode")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 C = gr1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    hr1 hr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof hr1)) {
                            hr1Var = (hr1) obj;
                        } else {
                            hr1Var = new hr1(this.mSwanApiContext);
                            this.mApis.put("1754780133", hr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(hr1Var, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Account.getOpenId")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = hr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    oq1 oq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof oq1)) {
                            oq1Var = (oq1) obj;
                        } else {
                            oq1Var = new oq1(this.mSwanApiContext);
                            this.mApis.put("-343998465", oq1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(oq1Var, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Account.getUnionBDUSS")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = oq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    er1 er1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof er1)) {
                            er1Var = (er1) obj;
                        } else {
                            er1Var = new er1(this.mSwanApiContext);
                            this.mApis.put("-337742792", er1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(er1Var, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Account.isBaiduAccountSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = er1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    gr1 gr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof gr1)) {
                            gr1Var = (gr1) obj;
                        } else {
                            gr1Var = new gr1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", gr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(gr1Var, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Account.isLoginSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 H = gr1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    gr1 gr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof gr1)) {
                            gr1Var = (gr1) obj;
                        } else {
                            gr1Var = new gr1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", gr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(gr1Var, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Account.login")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 I = gr1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    ir1 ir1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof ir1)) {
                            ir1Var = (ir1) obj;
                        } else {
                            ir1Var = new ir1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", ir1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ir1Var, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Basic.loadSubPackage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 F = ir1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    ir1 ir1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof ir1)) {
                            ir1Var = (ir1) obj;
                        } else {
                            ir1Var = new ir1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", ir1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ir1Var, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Basic.loadSubPackages")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 G = ir1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    pj1 pj1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof pj1)) {
                            pj1Var = (pj1) obj;
                        } else {
                            pj1Var = new pj1(this.mSwanApiContext);
                            this.mApis.put("1460300387", pj1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(pj1Var, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Bookshelf.deleteBookshelf")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 K = pj1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    pj1 pj1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof pj1)) {
                            pj1Var = (pj1) obj;
                        } else {
                            pj1Var = new pj1(this.mSwanApiContext);
                            this.mApis.put("1460300387", pj1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(pj1Var, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Bookshelf.insertBookshelf")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 P = pj1Var.P(str);
                        return P == null ? "" : P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    pj1 pj1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof pj1)) {
                            pj1Var = (pj1) obj;
                        } else {
                            pj1Var = new pj1(this.mSwanApiContext);
                            this.mApis.put("1460300387", pj1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(pj1Var, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Bookshelf.navigateToBookshelf")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 U = pj1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    pj1 pj1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof pj1)) {
                            pj1Var = (pj1) obj;
                        } else {
                            pj1Var = new pj1(this.mSwanApiContext);
                            this.mApis.put("1460300387", pj1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(pj1Var, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Bookshelf.queryBookshelf")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 V = pj1Var.V(str);
                        return V == null ? "" : V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    pj1 pj1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof pj1)) {
                            pj1Var = (pj1) obj;
                        } else {
                            pj1Var = new pj1(this.mSwanApiContext);
                            this.mApis.put("1460300387", pj1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(pj1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Bookshelf.updateBookshelfReadTime")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 X = pj1Var.X(str);
                        return X == null ? "" : X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    cr1 cr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("-277316359", cr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(cr1Var, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Coupon.getPlatformCoupons")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = cr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    cr1 cr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("-277316359", cr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(cr1Var, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Coupon.getUserCoupons")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 z = cr1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    cr1 cr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("-277316359", cr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(cr1Var, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Coupon.takeCoupons")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 C = cr1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    kr1 kr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof kr1)) {
                            kr1Var = (kr1) obj;
                        } else {
                            kr1Var = new kr1(this.mSwanApiContext);
                            this.mApis.put("-1225406515", kr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(kr1Var, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Favorite.getFavorStatus")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = kr1Var.x(str);
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
                        Pair<Boolean, xu1> a = zu1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Favorite.showFavoriteGuide")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 G = showFavoriteGuideApi.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    mr1 mr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof mr1)) {
                            mr1Var = (mr1) obj;
                        } else {
                            mr1Var = new mr1(this.mSwanApiContext);
                            this.mApis.put("-2057135077", mr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(mr1Var, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "File.shareFile")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = mr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    bg2 bg2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof bg2)) {
                            bg2Var = (bg2) obj;
                        } else {
                            bg2Var = new bg2(this.mSwanApiContext);
                            this.mApis.put("2077414795", bg2Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(bg2Var, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = bg2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    bg2 bg2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof bg2)) {
                            bg2Var = (bg2) obj;
                        } else {
                            bg2Var = new bg2(this.mSwanApiContext);
                            this.mApis.put("2077414795", bg2Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(bg2Var, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessageSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = bg2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String download(String str) {
                    nr1 nr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof nr1)) {
                            nr1Var = (nr1) obj;
                        } else {
                            nr1Var = new nr1(this.mSwanApiContext);
                            this.mApis.put("-170124576", nr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(nr1Var, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "HostDownloadManager.download")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = nr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    nr1 nr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof nr1)) {
                            nr1Var = (nr1) obj;
                        } else {
                            nr1Var = new nr1(this.mSwanApiContext);
                            this.mApis.put("-170124576", nr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(nr1Var, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "HostDownloadManager.openDownloadCenter")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = nr1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    nr1 nr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof nr1)) {
                            nr1Var = (nr1) obj;
                        } else {
                            nr1Var = new nr1(this.mSwanApiContext);
                            this.mApis.put("-170124576", nr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(nr1Var, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "HostDownloadManager.openFile")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 z = nr1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    nr1 nr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof nr1)) {
                            nr1Var = (nr1) obj;
                        } else {
                            nr1Var = new nr1(this.mSwanApiContext);
                            this.mApis.put("-170124576", nr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(nr1Var, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "HostDownloadManager.query")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 query = nr1Var.query(str);
                        return query == null ? "" : query.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naImage", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    ps2 ps2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof ps2)) {
                            ps2Var = (ps2) obj;
                        } else {
                            ps2Var = new ps2(this.mSwanApiContext);
                            this.mApis.put("1445003743", ps2Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ps2Var, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Image.callImageMenu")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = ps2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    qr1 qr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof qr1)) {
                            qr1Var = (qr1) obj;
                        } else {
                            qr1Var = new qr1(this.mSwanApiContext);
                            this.mApis.put("-1252730367", qr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(qr1Var, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Image.compressImage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = qr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    yr1 yr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof yr1)) {
                            yr1Var = (yr1) obj;
                        } else {
                            yr1Var = new yr1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", yr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(yr1Var, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.closeTabBar")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = yr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    yr1 yr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof yr1)) {
                            yr1Var = (yr1) obj;
                        } else {
                            yr1Var = new yr1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", yr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(yr1Var, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.closeTabBarRedDot")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = yr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    sr1 sr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof sr1)) {
                            sr1Var = (sr1) obj;
                        } else {
                            sr1Var = new sr1(this.mSwanApiContext);
                            this.mApis.put("5236036", sr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(sr1Var, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.hideLoading")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = sr1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    ur1 ur1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof ur1)) {
                            ur1Var = (ur1) obj;
                        } else {
                            ur1Var = new ur1(this.mSwanApiContext);
                            this.mApis.put("-246386074", ur1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ur1Var, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.hideNavigationBarLoading")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = ur1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    zr1 zr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof zr1)) {
                            zr1Var = (zr1) obj;
                        } else {
                            zr1Var = new zr1(this.mSwanApiContext);
                            this.mApis.put("1159492510", zr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(zr1Var, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.hideToast")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 K = zr1Var.K();
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    wr1 wr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof wr1)) {
                            wr1Var = (wr1) obj;
                        } else {
                            wr1Var = new wr1(this.mSwanApiContext);
                            this.mApis.put("-108978463", wr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(wr1Var, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.openMultiPicker")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 G = wr1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    wr1 wr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof wr1)) {
                            wr1Var = (wr1) obj;
                        } else {
                            wr1Var = new wr1(this.mSwanApiContext);
                            this.mApis.put("-108978463", wr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(wr1Var, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.openPicker")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 H = wr1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    yr1 yr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof yr1)) {
                            yr1Var = (yr1) obj;
                        } else {
                            yr1Var = new yr1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", yr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(yr1Var, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.openTabBar")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 C = yr1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    vr1 vr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof vr1)) {
                            vr1Var = (vr1) obj;
                        } else {
                            vr1Var = new vr1(this.mSwanApiContext);
                            this.mApis.put("-1750613704", vr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(vr1Var, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.pageScrollTo")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = vr1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    ur1 ur1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof ur1)) {
                            ur1Var = (ur1) obj;
                        } else {
                            ur1Var = new ur1(this.mSwanApiContext);
                            this.mApis.put("-246386074", ur1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ur1Var, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarColor")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 z = ur1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    ur1 ur1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof ur1)) {
                            ur1Var = (ur1) obj;
                        } else {
                            ur1Var = new ur1(this.mSwanApiContext);
                            this.mApis.put("-246386074", ur1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ur1Var, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarTitle")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = ur1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    yr1 yr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof yr1)) {
                            yr1Var = (yr1) obj;
                        } else {
                            yr1Var = new yr1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", yr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(yr1Var, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.setTabBarItem")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 D = yr1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    wr1 wr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof wr1)) {
                            wr1Var = (wr1) obj;
                        } else {
                            wr1Var = new wr1(this.mSwanApiContext);
                            this.mApis.put("-108978463", wr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(wr1Var, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.showDatePickerView")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 L = wr1Var.L(str);
                        return L == null ? "" : L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    as1 as1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof as1)) {
                            as1Var = (as1) obj;
                        } else {
                            as1Var = new as1(this.mSwanApiContext);
                            this.mApis.put("1172469410", as1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(as1Var, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.showHalfScreenWebview")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 K = as1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    sr1 sr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof sr1)) {
                            sr1Var = (sr1) obj;
                        } else {
                            sr1Var = new sr1(this.mSwanApiContext);
                            this.mApis.put("5236036", sr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(sr1Var, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.showLoading")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = sr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    tr1 tr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof tr1)) {
                            tr1Var = (tr1) obj;
                        } else {
                            tr1Var = new tr1(this.mSwanApiContext);
                            this.mApis.put("1913747800", tr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(tr1Var, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.showModal")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = tr1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    ur1 ur1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof ur1)) {
                            ur1Var = (ur1) obj;
                        } else {
                            ur1Var = new ur1(this.mSwanApiContext);
                            this.mApis.put("-246386074", ur1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ur1Var, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.showNavigationBarLoading")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 B = ur1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    zr1 zr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof zr1)) {
                            zr1Var = (zr1) obj;
                        } else {
                            zr1Var = new zr1(this.mSwanApiContext);
                            this.mApis.put("1159492510", zr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(zr1Var, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.showToast")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 Q = zr1Var.Q(str);
                        return Q == null ? "" : Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    xr1 xr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof xr1)) {
                            xr1Var = (xr1) obj;
                        } else {
                            xr1Var = new xr1(this.mSwanApiContext);
                            this.mApis.put("1165118609", xr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(xr1Var, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.stopPullDownRefresh")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = xr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    wr1 wr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof wr1)) {
                            wr1Var = (wr1) obj;
                        } else {
                            wr1Var = new wr1(this.mSwanApiContext);
                            this.mApis.put("-108978463", wr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(wr1Var, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.updateMultiPicker")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 M = wr1Var.M(str);
                        return M == null ? "" : M.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    bs1 bs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof bs1)) {
                            bs1Var = (bs1) obj;
                        } else {
                            bs1Var = new bs1(this.mSwanApiContext);
                            this.mApis.put("-137346255", bs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(bs1Var, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Keyboard.startKeyboardHeightChange")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 C = bs1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    bs1 bs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof bs1)) {
                            bs1Var = (bs1) obj;
                        } else {
                            bs1Var = new bs1(this.mSwanApiContext);
                            this.mApis.put("-137346255", bs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(bs1Var, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Keyboard.stopKeyboardHeightChange")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 D = bs1Var.D();
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    cs1 cs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof cs1)) {
                            cs1Var = (cs1) obj;
                        } else {
                            cs1Var = new cs1(this.mSwanApiContext);
                            this.mApis.put("-397373095", cs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(cs1Var, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "LocationService.getLocation")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = cs1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    cs1 cs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof cs1)) {
                            cs1Var = (cs1) obj;
                        } else {
                            cs1Var = new cs1(this.mSwanApiContext);
                            this.mApis.put("-397373095", cs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(cs1Var, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "LocationService.startLocationUpdate")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = cs1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    cs1 cs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof cs1)) {
                            cs1Var = (cs1) obj;
                        } else {
                            cs1Var = new cs1(this.mSwanApiContext);
                            this.mApis.put("-397373095", cs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(cs1Var, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "LocationService.stopLocationUpdate")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 B = cs1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    tt1 tt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof tt1)) {
                            tt1Var = (tt1) obj;
                        } else {
                            tt1Var = new tt1(this.mSwanApiContext);
                            this.mApis.put("538070032", tt1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(tt1Var, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = tt1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String callService(String str) {
                    fs1 fs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof fs1)) {
                            fs1Var = (fs1) obj;
                        } else {
                            fs1Var = new fs1(this.mSwanApiContext);
                            this.mApis.put("-1076509454", fs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(fs1Var, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Network.callService")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = fs1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    ms1 ms1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof ms1)) {
                            ms1Var = (ms1) obj;
                        } else {
                            ms1Var = new ms1(this.mSwanApiContext);
                            this.mApis.put("968563034", ms1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ms1Var, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Network.cancelRequest")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 D = ms1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    ls1 ls1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof ls1)) {
                            ls1Var = (ls1) obj;
                        } else {
                            ls1Var = new ls1(this.mSwanApiContext);
                            this.mApis.put("453220699", ls1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ls1Var, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Network.getNetworkType")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = ls1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    ls1 ls1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof ls1)) {
                            ls1Var = (ls1) obj;
                        } else {
                            ls1Var = new ls1(this.mSwanApiContext);
                            this.mApis.put("453220699", ls1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ls1Var, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Network.networkStatusChange")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = ls1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                @JavascriptInterface
                public String request(JsObject jsObject) {
                    InterceptResult invokeL2;
                    ms1 ms1Var;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && (invokeL2 = interceptable2.invokeL(1048580, this, jsObject)) != null) {
                        return (String) invokeL2.objValue;
                    }
                    try {
                        wu1.c().a("request");
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof ms1)) {
                            ms1Var = (ms1) obj;
                        } else {
                            ms1Var = new ms1(this.mSwanApiContext);
                            this.mApis.put("968563034", ms1Var);
                        }
                        Pair<Boolean, xu1> a2 = zu1.a(ms1Var, "swanAPI/request");
                        if (((Boolean) a2.first).booleanValue()) {
                            a = ((xu1) a2.second).a();
                        } else if (f52.a(this.mSwanApiContext.f(), "Network.request")) {
                            a = new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        } else {
                            Pair<xu1, JSONObject> t = br1.t(jsObject);
                            if (!((xu1) t.first).isSuccess()) {
                                a = ((xu1) t.first).a();
                            } else {
                                JSONObject jSONObject = (JSONObject) t.second;
                                if (jSONObject == null) {
                                    a = xu1.a.a();
                                } else {
                                    yu1 V = ms1Var.V(jSONObject);
                                    a = V == null ? "" : V.a();
                                }
                            }
                        }
                        return a;
                    } finally {
                    }
                }
            });
            hashMap.put("_naPayment", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    vv2 vv2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof vv2)) {
                            vv2Var = (vv2) obj;
                        } else {
                            vv2Var = new vv2(this.mSwanApiContext);
                            this.mApis.put("-336396851", vv2Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(vv2Var, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Payment.chooseCoupon")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = vv2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    vv2 vv2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof vv2)) {
                            vv2Var = (vv2) obj;
                        } else {
                            vv2Var = new vv2(this.mSwanApiContext);
                            this.mApis.put("-336396851", vv2Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(vv2Var, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Payment.getPaymentInfo")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = vv2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    lv2 lv2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof lv2)) {
                            lv2Var = (lv2) obj;
                        } else {
                            lv2Var = new lv2(this.mSwanApiContext);
                            this.mApis.put("1854689529", lv2Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(lv2Var, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Payment.requestThirdPayment")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = lv2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    vv2 vv2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof vv2)) {
                            vv2Var = (vv2) obj;
                        } else {
                            vv2Var = new vv2(this.mSwanApiContext);
                            this.mApis.put("-336396851", vv2Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(vv2Var, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Payment.setPaymentInfo")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 z = vv2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    gy2 gy2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof gy2)) {
                            gy2Var = (gy2) obj;
                        } else {
                            gy2Var = new gy2(this.mSwanApiContext);
                            this.mApis.put("-254510461", gy2Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(gy2Var, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Plugin.invokePluginChooseAddress")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = gy2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    gy2 gy2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof gy2)) {
                            gy2Var = (gy2) obj;
                        } else {
                            gy2Var = new gy2(this.mSwanApiContext);
                            this.mApis.put("-254510461", gy2Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(gy2Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 z = gy2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    gy2 gy2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof gy2)) {
                            gy2Var = (gy2) obj;
                        } else {
                            gy2Var = new gy2(this.mSwanApiContext);
                            this.mApis.put("-254510461", gy2Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(gy2Var, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Plugin.invokePluginPayment")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = gy2Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    z62 z62Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof z62)) {
                            z62Var = (z62) obj;
                        } else {
                            z62Var = new z62(this.mSwanApiContext);
                            this.mApis.put("-2068479848", z62Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(z62Var, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Prefetch.prefetchResources")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = z62Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    r52 r52Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof r52)) {
                            r52Var = (r52) obj;
                        } else {
                            r52Var = new r52(this.mSwanApiContext);
                            this.mApis.put("423661539", r52Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(r52Var, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Preload.preloadStatus")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = r52Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    bf3 bf3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof bf3)) {
                            bf3Var = (bf3) obj;
                        } else {
                            bf3Var = new bf3(this.mSwanApiContext);
                            this.mApis.put("-1929343869", bf3Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(bf3Var, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "PrivateFile.uploadFileToBos")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 C = bf3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    qs1 qs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof qs1)) {
                            qs1Var = (qs1) obj;
                        } else {
                            qs1Var = new qs1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", qs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(qs1Var, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Router.hideModalPage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = qs1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    qs1 qs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof qs1)) {
                            qs1Var = (qs1) obj;
                        } else {
                            qs1Var = new qs1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", qs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(qs1Var, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Router.navigateBack")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 B = qs1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    rs1 rs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof rs1)) {
                            rs1Var = (rs1) obj;
                        } else {
                            rs1Var = new rs1(this.mSwanApiContext);
                            this.mApis.put("1968522584", rs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(rs1Var, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Router.navigateTo")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 H = rs1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    ts1 ts1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof ts1)) {
                            ts1Var = (ts1) obj;
                        } else {
                            ts1Var = new ts1(this.mSwanApiContext);
                            this.mApis.put("1317280190", ts1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ts1Var, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Router.reLaunch")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = ts1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    us1 us1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof us1)) {
                            us1Var = (us1) obj;
                        } else {
                            us1Var = new us1(this.mSwanApiContext);
                            this.mApis.put("-420075743", us1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(us1Var, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Router.reLoadErrorPage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = us1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    ss1 ss1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof ss1)) {
                            ss1Var = (ss1) obj;
                        } else {
                            ss1Var = new ss1(this.mSwanApiContext);
                            this.mApis.put("1792515533", ss1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ss1Var, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Router.redirectTo")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 D = ss1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    rs1 rs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof rs1)) {
                            rs1Var = (rs1) obj;
                        } else {
                            rs1Var = new rs1(this.mSwanApiContext);
                            this.mApis.put("1968522584", rs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(rs1Var, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Router.showModalPage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 J = rs1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    xs1 xs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof xs1)) {
                            xs1Var = (xs1) obj;
                        } else {
                            xs1Var = new xs1(this.mSwanApiContext);
                            this.mApis.put("-594895721", xs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(xs1Var, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Setting.getAppInfoSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 F = xs1Var.F();
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    xs1 xs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof xs1)) {
                            xs1Var = (xs1) obj;
                        } else {
                            xs1Var = new xs1(this.mSwanApiContext);
                            this.mApis.put("-594895721", xs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(xs1Var, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Setting.getSetting")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 G = xs1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    xs1 xs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof xs1)) {
                            xs1Var = (xs1) obj;
                        } else {
                            xs1Var = new xs1(this.mSwanApiContext);
                            this.mApis.put("-594895721", xs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(xs1Var, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Setting.getSlaveIdSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 H = xs1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    xs1 xs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof xs1)) {
                            xs1Var = (xs1) obj;
                        } else {
                            xs1Var = new xs1(this.mSwanApiContext);
                            this.mApis.put("-594895721", xs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(xs1Var, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Setting.getSwanId")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 I = xs1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    xs1 xs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof xs1)) {
                            xs1Var = (xs1) obj;
                        } else {
                            xs1Var = new xs1(this.mSwanApiContext);
                            this.mApis.put("-594895721", xs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(xs1Var, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Setting.getUserInfo")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 J = xs1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    ws1 ws1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof ws1)) {
                            ws1Var = (ws1) obj;
                        } else {
                            ws1Var = new ws1(this.mSwanApiContext);
                            this.mApis.put("450273045", ws1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ws1Var, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Setting.isAllowedAdOpenAppSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = ws1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    v93 v93Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof v93)) {
                            v93Var = (v93) obj;
                        } else {
                            v93Var = new v93(this.mSwanApiContext);
                            this.mApis.put("712777136", v93Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(v93Var, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = v93Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    at1 at1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("-804054859", at1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(at1Var, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = at1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    at1 at1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("-804054859", at1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(at1Var, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorageSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 C = at1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    zs1 zs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("130910081", zs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(zs1Var, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.clearStorage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = zs1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    zs1 zs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("130910081", zs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(zs1Var, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.clearStorageSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 C = zs1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    at1 at1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("-804054859", at1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(at1Var, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.getGlobalStorage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 D = at1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    at1 at1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("-804054859", at1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(at1Var, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfo")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 G = at1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    at1 at1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("-804054859", at1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(at1Var, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfoSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 J = at1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    at1 at1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("-804054859", at1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(at1Var, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 K = at1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    zs1 zs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("130910081", zs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(zs1Var, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.getStorage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 D = zs1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    zs1 zs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("130910081", zs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(zs1Var, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.getStorageInfo")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 G = zs1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    zs1 zs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("130910081", zs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(zs1Var, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.getStorageInfoAsync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 H = zs1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    zs1 zs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("130910081", zs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(zs1Var, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.getStorageInfoSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 J = zs1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    zs1 zs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("130910081", zs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(zs1Var, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.getStorageSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 K = zs1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    at1 at1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("-804054859", at1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(at1Var, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 R = at1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    at1 at1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("-804054859", at1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(at1Var, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorageSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 T = at1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    zs1 zs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("130910081", zs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(zs1Var, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.removeStorage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 R = zs1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    zs1 zs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("130910081", zs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(zs1Var, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.removeStorageSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 T = zs1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    at1 at1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("-804054859", at1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(at1Var, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.setGlobalStorage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 U = at1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    at1 at1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("-804054859", at1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(at1Var, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.setGlobalStorageSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 W = at1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    zs1 zs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("130910081", zs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(zs1Var, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.setStorage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 U = zs1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    zs1 zs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("130910081", zs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(zs1Var, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.setStorageSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 W = zs1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    ct1 ct1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof ct1)) {
                            ct1Var = (ct1) obj;
                        } else {
                            ct1Var = new ct1(this.mSwanApiContext);
                            this.mApis.put("823117982", ct1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ct1Var, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Subscription.requestSubscribeFormId")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 E = ct1Var.E(str);
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    dt1 dt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof dt1)) {
                            dt1Var = (dt1) obj;
                        } else {
                            dt1Var = new dt1(this.mSwanApiContext);
                            this.mApis.put("-947445811", dt1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(dt1Var, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Subscription.subscribeService")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 F = dt1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    kt1 kt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof kt1)) {
                            kt1Var = (kt1) obj;
                        } else {
                            kt1Var = new kt1(this.mSwanApiContext);
                            this.mApis.put("1936205521", kt1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(kt1Var, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.exitFullScreen")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = kt1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    gt1 gt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof gt1)) {
                            gt1Var = (gt1) obj;
                        } else {
                            gt1Var = new gt1(this.mSwanApiContext);
                            this.mApis.put("99997465", gt1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(gt1Var, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.getBrightness")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = gt1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    ht1 ht1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof ht1)) {
                            ht1Var = (ht1) obj;
                        } else {
                            ht1Var = new ht1(this.mSwanApiContext);
                            this.mApis.put("-518757484", ht1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ht1Var, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.getClipboardData")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = ht1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    jt1 jt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof jt1)) {
                            jt1Var = (jt1) obj;
                        } else {
                            jt1Var = new jt1(this.mSwanApiContext);
                            this.mApis.put("1694151270", jt1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(jt1Var, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.getDeviceInfo")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = jt1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    lt1 lt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof lt1)) {
                            lt1Var = (lt1) obj;
                        } else {
                            lt1Var = new lt1(this.mSwanApiContext);
                            this.mApis.put("-1321681619", lt1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(lt1Var, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.getDeviceProfile")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = lt1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    rt1 rt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof rt1)) {
                            rt1Var = (rt1) obj;
                        } else {
                            rt1Var = new rt1(this.mSwanApiContext);
                            this.mApis.put("447234992", rt1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(rt1Var, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.getMediaVolume")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = rt1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    mt1 mt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("-1569246082", mt1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(mt1Var, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.makePhoneCall")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = mt1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    ot1 ot1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof ot1)) {
                            ot1Var = (ot1) obj;
                        } else {
                            ot1Var = new ot1(this.mSwanApiContext);
                            this.mApis.put("1099851202", ot1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ot1Var, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.openSMSPanel")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = ot1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("-1707203360", nt1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(nt1Var, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.requestFullScreen")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 F = nt1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    ht1 ht1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof ht1)) {
                            ht1Var = (ht1) obj;
                        } else {
                            ht1Var = new ht1(this.mSwanApiContext);
                            this.mApis.put("-518757484", ht1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ht1Var, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.setClipboardData")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = ht1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    rs2 rs2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof rs2)) {
                            rs2Var = (rs2) obj;
                        } else {
                            rs2Var = new rs2(this.mSwanApiContext);
                            this.mApis.put("1161486049", rs2Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(rs2Var, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.setErrorPageType")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = rs2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    rt1 rt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof rt1)) {
                            rt1Var = (rt1) obj;
                        } else {
                            rt1Var = new rt1(this.mSwanApiContext);
                            this.mApis.put("447234992", rt1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(rt1Var, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.setMediaVolume")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 z = rt1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    ft1 ft1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("1372680763", ft1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ft1Var, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.startAccelerometer")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = ft1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    it1 it1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof it1)) {
                            it1Var = (it1) obj;
                        } else {
                            it1Var = new it1(this.mSwanApiContext);
                            this.mApis.put("1689255576", it1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(it1Var, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.startCompass")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = it1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    ft1 ft1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("1372680763", ft1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ft1Var, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.stopAccelerometer")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 B = ft1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    it1 it1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof it1)) {
                            it1Var = (it1) obj;
                        } else {
                            it1Var = new it1(this.mSwanApiContext);
                            this.mApis.put("1689255576", it1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(it1Var, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.stopCompass")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 z = it1Var.z();
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    cu1 cu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof cu1)) {
                            cu1Var = (cu1) obj;
                        } else {
                            cu1Var = new cu1(this.mSwanApiContext);
                            this.mApis.put("201194468", cu1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(cu1Var, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.addToDesktop")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 B = cu1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    yt1 yt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof yt1)) {
                            yt1Var = (yt1) obj;
                        } else {
                            yt1Var = new yt1(this.mSwanApiContext);
                            this.mApis.put("-1412306947", yt1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(yt1Var, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.calcMD5")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = yt1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    zt1 zt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof zt1)) {
                            zt1Var = (zt1) obj;
                        } else {
                            zt1Var = new zt1(this.mSwanApiContext);
                            this.mApis.put("1626415364", zt1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(zt1Var, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.checkAppInstalled")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = zt1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    bu1 bu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof bu1)) {
                            bu1Var = (bu1) obj;
                        } else {
                            bu1Var = new bu1(this.mSwanApiContext);
                            this.mApis.put("-836768778", bu1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(bu1Var, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfo")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = bu1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    hu1 hu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", hu1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(hu1Var, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfoSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 E = hu1Var.E();
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    du1 du1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof du1)) {
                            du1Var = (du1) obj;
                        } else {
                            du1Var = new du1(this.mSwanApiContext);
                            this.mApis.put("-810858308", du1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(du1Var, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.getPerformanceLevel")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = du1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    hu1 hu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", hu1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(hu1Var, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.getSystemInfo")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 H = hu1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    hu1 hu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", hu1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(hu1Var, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.getSystemInfoAsync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 I = hu1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    hu1 hu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", hu1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(hu1Var, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.getSystemInfoSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 J = hu1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    eu1 eu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof eu1)) {
                            eu1Var = (eu1) obj;
                        } else {
                            eu1Var = new eu1(this.mSwanApiContext);
                            this.mApis.put("-2097727681", eu1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(eu1Var, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.handleException")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = eu1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    au1 au1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof au1)) {
                            au1Var = (au1) obj;
                        } else {
                            au1Var = new au1(this.mSwanApiContext);
                            this.mApis.put("2084449317", au1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(au1Var, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.hasCloseHandler")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = au1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    d73 d73Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof d73)) {
                            d73Var = (d73) obj;
                        } else {
                            d73Var = new d73(this.mSwanApiContext);
                            this.mApis.put("1031678042", d73Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(d73Var, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.hideCaptureScreenShareDialog")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = d73Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    fu1 fu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("1751900130", fu1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(fu1Var, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.logToFile")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = fu1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    e63 e63Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof e63)) {
                            e63Var = (e63) obj;
                        } else {
                            e63Var = new e63(this.mSwanApiContext);
                            this.mApis.put("1748196865", e63Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(e63Var, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.preloadPackage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = e63Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    gu1 gu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("589529211", gu1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(gu1Var, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.previewImage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 B = gu1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    ju1 ju1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof ju1)) {
                            ju1Var = (ju1) obj;
                        } else {
                            ju1Var = new ju1(this.mSwanApiContext);
                            this.mApis.put("-577481801", ju1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ju1Var, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.ubcFlowJar")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 I = ju1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    od3 od3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof od3)) {
                            od3Var = (od3) obj;
                        } else {
                            od3Var = new od3(this.mSwanApiContext);
                            this.mApis.put("1879401452", od3Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(od3Var, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Wifi.connectWifi")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = od3Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    od3 od3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof od3)) {
                            od3Var = (od3) obj;
                        } else {
                            od3Var = new od3(this.mSwanApiContext);
                            this.mApis.put("1879401452", od3Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(od3Var, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Wifi.getConnectedWifi")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 B = od3Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    od3 od3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof od3)) {
                            od3Var = (od3) obj;
                        } else {
                            od3Var = new od3(this.mSwanApiContext);
                            this.mApis.put("1879401452", od3Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(od3Var, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Wifi.getWifiList")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 C = od3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    od3 od3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof od3)) {
                            od3Var = (od3) obj;
                        } else {
                            od3Var = new od3(this.mSwanApiContext);
                            this.mApis.put("1879401452", od3Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(od3Var, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Wifi.startWifi")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 G = od3Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    od3 od3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof od3)) {
                            od3Var = (od3) obj;
                        } else {
                            od3Var = new od3(this.mSwanApiContext);
                            this.mApis.put("1879401452", od3Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(od3Var, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Wifi.stopWifi")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 H = od3Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static Map<String, Object> getWebviewApiModules(final zq1 zq1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, zq1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    fr1 fr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof fr1)) {
                            fr1Var = (fr1) obj;
                        } else {
                            fr1Var = new fr1(this.mSwanApiContext);
                            this.mApis.put("1930258908", fr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(fr1Var, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Account.checkSession")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = fr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    gr1 gr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof gr1)) {
                            gr1Var = (gr1) obj;
                        } else {
                            gr1Var = new gr1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", gr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(gr1Var, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Account.getLoginCode")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 C = gr1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    hr1 hr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof hr1)) {
                            hr1Var = (hr1) obj;
                        } else {
                            hr1Var = new hr1(this.mSwanApiContext);
                            this.mApis.put("1754780133", hr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(hr1Var, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Account.getOpenId")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = hr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    oq1 oq1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof oq1)) {
                            oq1Var = (oq1) obj;
                        } else {
                            oq1Var = new oq1(this.mSwanApiContext);
                            this.mApis.put("-343998465", oq1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(oq1Var, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Account.getUnionBDUSS")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = oq1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    er1 er1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof er1)) {
                            er1Var = (er1) obj;
                        } else {
                            er1Var = new er1(this.mSwanApiContext);
                            this.mApis.put("-337742792", er1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(er1Var, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Account.isBaiduAccountSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = er1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    gr1 gr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof gr1)) {
                            gr1Var = (gr1) obj;
                        } else {
                            gr1Var = new gr1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", gr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(gr1Var, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Account.isLoginSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 H = gr1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    gr1 gr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof gr1)) {
                            gr1Var = (gr1) obj;
                        } else {
                            gr1Var = new gr1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", gr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(gr1Var, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Account.login")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 I = gr1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    ir1 ir1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof ir1)) {
                            ir1Var = (ir1) obj;
                        } else {
                            ir1Var = new ir1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", ir1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ir1Var, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Basic.loadSubPackage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 F = ir1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    ir1 ir1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof ir1)) {
                            ir1Var = (ir1) obj;
                        } else {
                            ir1Var = new ir1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", ir1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ir1Var, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Basic.loadSubPackages")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 G = ir1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    pj1 pj1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof pj1)) {
                            pj1Var = (pj1) obj;
                        } else {
                            pj1Var = new pj1(this.mSwanApiContext);
                            this.mApis.put("1460300387", pj1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(pj1Var, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Bookshelf.deleteBookshelf")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 K = pj1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    pj1 pj1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof pj1)) {
                            pj1Var = (pj1) obj;
                        } else {
                            pj1Var = new pj1(this.mSwanApiContext);
                            this.mApis.put("1460300387", pj1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(pj1Var, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Bookshelf.insertBookshelf")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 P = pj1Var.P(str);
                        return P == null ? "" : P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    pj1 pj1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof pj1)) {
                            pj1Var = (pj1) obj;
                        } else {
                            pj1Var = new pj1(this.mSwanApiContext);
                            this.mApis.put("1460300387", pj1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(pj1Var, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Bookshelf.navigateToBookshelf")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 U = pj1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    pj1 pj1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof pj1)) {
                            pj1Var = (pj1) obj;
                        } else {
                            pj1Var = new pj1(this.mSwanApiContext);
                            this.mApis.put("1460300387", pj1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(pj1Var, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Bookshelf.queryBookshelf")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 V = pj1Var.V(str);
                        return V == null ? "" : V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    pj1 pj1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof pj1)) {
                            pj1Var = (pj1) obj;
                        } else {
                            pj1Var = new pj1(this.mSwanApiContext);
                            this.mApis.put("1460300387", pj1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(pj1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Bookshelf.updateBookshelfReadTime")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 X = pj1Var.X(str);
                        return X == null ? "" : X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    cr1 cr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("-277316359", cr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(cr1Var, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Coupon.getPlatformCoupons")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = cr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    cr1 cr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("-277316359", cr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(cr1Var, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Coupon.getUserCoupons")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 z = cr1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    cr1 cr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof cr1)) {
                            cr1Var = (cr1) obj;
                        } else {
                            cr1Var = new cr1(this.mSwanApiContext);
                            this.mApis.put("-277316359", cr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(cr1Var, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Coupon.takeCoupons")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 C = cr1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    kr1 kr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof kr1)) {
                            kr1Var = (kr1) obj;
                        } else {
                            kr1Var = new kr1(this.mSwanApiContext);
                            this.mApis.put("-1225406515", kr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(kr1Var, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Favorite.getFavorStatus")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = kr1Var.x(str);
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
                        Pair<Boolean, xu1> a = zu1.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Favorite.showFavoriteGuide")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 G = showFavoriteGuideApi.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    mr1 mr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof mr1)) {
                            mr1Var = (mr1) obj;
                        } else {
                            mr1Var = new mr1(this.mSwanApiContext);
                            this.mApis.put("-2057135077", mr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(mr1Var, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "File.shareFile")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = mr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    bg2 bg2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof bg2)) {
                            bg2Var = (bg2) obj;
                        } else {
                            bg2Var = new bg2(this.mSwanApiContext);
                            this.mApis.put("2077414795", bg2Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(bg2Var, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = bg2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    bg2 bg2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof bg2)) {
                            bg2Var = (bg2) obj;
                        } else {
                            bg2Var = new bg2(this.mSwanApiContext);
                            this.mApis.put("2077414795", bg2Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(bg2Var, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessageSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = bg2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String download(String str) {
                    nr1 nr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof nr1)) {
                            nr1Var = (nr1) obj;
                        } else {
                            nr1Var = new nr1(this.mSwanApiContext);
                            this.mApis.put("-170124576", nr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(nr1Var, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "HostDownloadManager.download")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = nr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    nr1 nr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof nr1)) {
                            nr1Var = (nr1) obj;
                        } else {
                            nr1Var = new nr1(this.mSwanApiContext);
                            this.mApis.put("-170124576", nr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(nr1Var, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "HostDownloadManager.openDownloadCenter")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = nr1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    nr1 nr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof nr1)) {
                            nr1Var = (nr1) obj;
                        } else {
                            nr1Var = new nr1(this.mSwanApiContext);
                            this.mApis.put("-170124576", nr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(nr1Var, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "HostDownloadManager.openFile")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 z = nr1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    nr1 nr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof nr1)) {
                            nr1Var = (nr1) obj;
                        } else {
                            nr1Var = new nr1(this.mSwanApiContext);
                            this.mApis.put("-170124576", nr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(nr1Var, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "HostDownloadManager.query")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 query = nr1Var.query(str);
                        return query == null ? "" : query.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naImage", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    ps2 ps2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof ps2)) {
                            ps2Var = (ps2) obj;
                        } else {
                            ps2Var = new ps2(this.mSwanApiContext);
                            this.mApis.put("1445003743", ps2Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ps2Var, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Image.callImageMenu")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = ps2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    qr1 qr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof qr1)) {
                            qr1Var = (qr1) obj;
                        } else {
                            qr1Var = new qr1(this.mSwanApiContext);
                            this.mApis.put("-1252730367", qr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(qr1Var, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Image.compressImage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = qr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    yr1 yr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof yr1)) {
                            yr1Var = (yr1) obj;
                        } else {
                            yr1Var = new yr1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", yr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(yr1Var, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.closeTabBar")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = yr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    yr1 yr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof yr1)) {
                            yr1Var = (yr1) obj;
                        } else {
                            yr1Var = new yr1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", yr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(yr1Var, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.closeTabBarRedDot")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = yr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    sr1 sr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof sr1)) {
                            sr1Var = (sr1) obj;
                        } else {
                            sr1Var = new sr1(this.mSwanApiContext);
                            this.mApis.put("5236036", sr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(sr1Var, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.hideLoading")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = sr1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    ur1 ur1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof ur1)) {
                            ur1Var = (ur1) obj;
                        } else {
                            ur1Var = new ur1(this.mSwanApiContext);
                            this.mApis.put("-246386074", ur1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ur1Var, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.hideNavigationBarLoading")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = ur1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    zr1 zr1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof zr1)) {
                            zr1Var = (zr1) obj;
                        } else {
                            zr1Var = new zr1(this.mSwanApiContext);
                            this.mApis.put("1159492510", zr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(zr1Var, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.hideToast")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 K = zr1Var.K();
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    wr1 wr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof wr1)) {
                            wr1Var = (wr1) obj;
                        } else {
                            wr1Var = new wr1(this.mSwanApiContext);
                            this.mApis.put("-108978463", wr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(wr1Var, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.openMultiPicker")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 G = wr1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    wr1 wr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof wr1)) {
                            wr1Var = (wr1) obj;
                        } else {
                            wr1Var = new wr1(this.mSwanApiContext);
                            this.mApis.put("-108978463", wr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(wr1Var, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.openPicker")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 H = wr1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    yr1 yr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof yr1)) {
                            yr1Var = (yr1) obj;
                        } else {
                            yr1Var = new yr1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", yr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(yr1Var, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.openTabBar")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 C = yr1Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    vr1 vr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof vr1)) {
                            vr1Var = (vr1) obj;
                        } else {
                            vr1Var = new vr1(this.mSwanApiContext);
                            this.mApis.put("-1750613704", vr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(vr1Var, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.pageScrollTo")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = vr1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    ur1 ur1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof ur1)) {
                            ur1Var = (ur1) obj;
                        } else {
                            ur1Var = new ur1(this.mSwanApiContext);
                            this.mApis.put("-246386074", ur1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ur1Var, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarColor")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 z = ur1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    ur1 ur1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof ur1)) {
                            ur1Var = (ur1) obj;
                        } else {
                            ur1Var = new ur1(this.mSwanApiContext);
                            this.mApis.put("-246386074", ur1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ur1Var, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarTitle")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = ur1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    yr1 yr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof yr1)) {
                            yr1Var = (yr1) obj;
                        } else {
                            yr1Var = new yr1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", yr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(yr1Var, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.setTabBarItem")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 D = yr1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    wr1 wr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof wr1)) {
                            wr1Var = (wr1) obj;
                        } else {
                            wr1Var = new wr1(this.mSwanApiContext);
                            this.mApis.put("-108978463", wr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(wr1Var, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.showDatePickerView")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 L = wr1Var.L(str);
                        return L == null ? "" : L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    as1 as1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof as1)) {
                            as1Var = (as1) obj;
                        } else {
                            as1Var = new as1(this.mSwanApiContext);
                            this.mApis.put("1172469410", as1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(as1Var, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.showHalfScreenWebview")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 K = as1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    sr1 sr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof sr1)) {
                            sr1Var = (sr1) obj;
                        } else {
                            sr1Var = new sr1(this.mSwanApiContext);
                            this.mApis.put("5236036", sr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(sr1Var, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.showLoading")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = sr1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    tr1 tr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof tr1)) {
                            tr1Var = (tr1) obj;
                        } else {
                            tr1Var = new tr1(this.mSwanApiContext);
                            this.mApis.put("1913747800", tr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(tr1Var, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.showModal")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = tr1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    ur1 ur1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof ur1)) {
                            ur1Var = (ur1) obj;
                        } else {
                            ur1Var = new ur1(this.mSwanApiContext);
                            this.mApis.put("-246386074", ur1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ur1Var, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.showNavigationBarLoading")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 B = ur1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    zr1 zr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof zr1)) {
                            zr1Var = (zr1) obj;
                        } else {
                            zr1Var = new zr1(this.mSwanApiContext);
                            this.mApis.put("1159492510", zr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(zr1Var, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.showToast")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 Q = zr1Var.Q(str);
                        return Q == null ? "" : Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    xr1 xr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof xr1)) {
                            xr1Var = (xr1) obj;
                        } else {
                            xr1Var = new xr1(this.mSwanApiContext);
                            this.mApis.put("1165118609", xr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(xr1Var, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.stopPullDownRefresh")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = xr1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    wr1 wr1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof wr1)) {
                            wr1Var = (wr1) obj;
                        } else {
                            wr1Var = new wr1(this.mSwanApiContext);
                            this.mApis.put("-108978463", wr1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(wr1Var, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Interaction.updateMultiPicker")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 M = wr1Var.M(str);
                        return M == null ? "" : M.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    bs1 bs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof bs1)) {
                            bs1Var = (bs1) obj;
                        } else {
                            bs1Var = new bs1(this.mSwanApiContext);
                            this.mApis.put("-137346255", bs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(bs1Var, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Keyboard.startKeyboardHeightChange")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 C = bs1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    bs1 bs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof bs1)) {
                            bs1Var = (bs1) obj;
                        } else {
                            bs1Var = new bs1(this.mSwanApiContext);
                            this.mApis.put("-137346255", bs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(bs1Var, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Keyboard.stopKeyboardHeightChange")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 D = bs1Var.D();
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    cs1 cs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof cs1)) {
                            cs1Var = (cs1) obj;
                        } else {
                            cs1Var = new cs1(this.mSwanApiContext);
                            this.mApis.put("-397373095", cs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(cs1Var, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "LocationService.getLocation")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = cs1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    cs1 cs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof cs1)) {
                            cs1Var = (cs1) obj;
                        } else {
                            cs1Var = new cs1(this.mSwanApiContext);
                            this.mApis.put("-397373095", cs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(cs1Var, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "LocationService.startLocationUpdate")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = cs1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    cs1 cs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof cs1)) {
                            cs1Var = (cs1) obj;
                        } else {
                            cs1Var = new cs1(this.mSwanApiContext);
                            this.mApis.put("-397373095", cs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(cs1Var, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "LocationService.stopLocationUpdate")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 B = cs1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    tt1 tt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof tt1)) {
                            tt1Var = (tt1) obj;
                        } else {
                            tt1Var = new tt1(this.mSwanApiContext);
                            this.mApis.put("538070032", tt1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(tt1Var, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = tt1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String callService(String str) {
                    fs1 fs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof fs1)) {
                            fs1Var = (fs1) obj;
                        } else {
                            fs1Var = new fs1(this.mSwanApiContext);
                            this.mApis.put("-1076509454", fs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(fs1Var, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Network.callService")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = fs1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    ms1 ms1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof ms1)) {
                            ms1Var = (ms1) obj;
                        } else {
                            ms1Var = new ms1(this.mSwanApiContext);
                            this.mApis.put("968563034", ms1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ms1Var, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Network.cancelRequest")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 D = ms1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    ls1 ls1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof ls1)) {
                            ls1Var = (ls1) obj;
                        } else {
                            ls1Var = new ls1(this.mSwanApiContext);
                            this.mApis.put("453220699", ls1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ls1Var, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Network.getNetworkType")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = ls1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    ls1 ls1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof ls1)) {
                            ls1Var = (ls1) obj;
                        } else {
                            ls1Var = new ls1(this.mSwanApiContext);
                            this.mApis.put("453220699", ls1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ls1Var, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Network.networkStatusChange")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = ls1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                @JavascriptInterface
                public String request(String str) {
                    InterceptResult invokeL2;
                    ms1 ms1Var;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && (invokeL2 = interceptable2.invokeL(1048580, this, str)) != null) {
                        return (String) invokeL2.objValue;
                    }
                    try {
                        wu1.c().a("request");
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof ms1)) {
                            ms1Var = (ms1) obj;
                        } else {
                            ms1Var = new ms1(this.mSwanApiContext);
                            this.mApis.put("968563034", ms1Var);
                        }
                        Pair<Boolean, xu1> a2 = zu1.a(ms1Var, "swanAPI/request");
                        if (((Boolean) a2.first).booleanValue()) {
                            a = ((xu1) a2.second).a();
                        } else if (f52.a(this.mSwanApiContext.f(), "Network.request")) {
                            a = new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        } else {
                            Pair<xu1, JSONObject> u = br1.u(str);
                            if (!((xu1) u.first).isSuccess()) {
                                a = ((xu1) u.first).a();
                            } else {
                                JSONObject jSONObject = (JSONObject) u.second;
                                if (jSONObject == null) {
                                    a = xu1.a.a();
                                } else {
                                    yu1 V = ms1Var.V(jSONObject);
                                    a = V == null ? "" : V.a();
                                }
                            }
                        }
                        return a;
                    } finally {
                    }
                }
            });
            hashMap.put("_naPayment", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    vv2 vv2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof vv2)) {
                            vv2Var = (vv2) obj;
                        } else {
                            vv2Var = new vv2(this.mSwanApiContext);
                            this.mApis.put("-336396851", vv2Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(vv2Var, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Payment.chooseCoupon")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = vv2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    vv2 vv2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof vv2)) {
                            vv2Var = (vv2) obj;
                        } else {
                            vv2Var = new vv2(this.mSwanApiContext);
                            this.mApis.put("-336396851", vv2Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(vv2Var, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Payment.getPaymentInfo")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = vv2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    lv2 lv2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof lv2)) {
                            lv2Var = (lv2) obj;
                        } else {
                            lv2Var = new lv2(this.mSwanApiContext);
                            this.mApis.put("1854689529", lv2Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(lv2Var, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Payment.requestThirdPayment")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = lv2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    vv2 vv2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof vv2)) {
                            vv2Var = (vv2) obj;
                        } else {
                            vv2Var = new vv2(this.mSwanApiContext);
                            this.mApis.put("-336396851", vv2Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(vv2Var, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Payment.setPaymentInfo")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 z = vv2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    gy2 gy2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof gy2)) {
                            gy2Var = (gy2) obj;
                        } else {
                            gy2Var = new gy2(this.mSwanApiContext);
                            this.mApis.put("-254510461", gy2Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(gy2Var, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Plugin.invokePluginChooseAddress")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = gy2Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    gy2 gy2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof gy2)) {
                            gy2Var = (gy2) obj;
                        } else {
                            gy2Var = new gy2(this.mSwanApiContext);
                            this.mApis.put("-254510461", gy2Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(gy2Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 z = gy2Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    gy2 gy2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof gy2)) {
                            gy2Var = (gy2) obj;
                        } else {
                            gy2Var = new gy2(this.mSwanApiContext);
                            this.mApis.put("-254510461", gy2Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(gy2Var, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Plugin.invokePluginPayment")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = gy2Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    z62 z62Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof z62)) {
                            z62Var = (z62) obj;
                        } else {
                            z62Var = new z62(this.mSwanApiContext);
                            this.mApis.put("-2068479848", z62Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(z62Var, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Prefetch.prefetchResources")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = z62Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    r52 r52Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof r52)) {
                            r52Var = (r52) obj;
                        } else {
                            r52Var = new r52(this.mSwanApiContext);
                            this.mApis.put("423661539", r52Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(r52Var, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Preload.preloadStatus")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = r52Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    bf3 bf3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof bf3)) {
                            bf3Var = (bf3) obj;
                        } else {
                            bf3Var = new bf3(this.mSwanApiContext);
                            this.mApis.put("-1929343869", bf3Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(bf3Var, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "PrivateFile.uploadFileToBos")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 C = bf3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    qs1 qs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof qs1)) {
                            qs1Var = (qs1) obj;
                        } else {
                            qs1Var = new qs1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", qs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(qs1Var, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Router.hideModalPage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = qs1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    qs1 qs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof qs1)) {
                            qs1Var = (qs1) obj;
                        } else {
                            qs1Var = new qs1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", qs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(qs1Var, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Router.navigateBack")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 B = qs1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    rs1 rs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof rs1)) {
                            rs1Var = (rs1) obj;
                        } else {
                            rs1Var = new rs1(this.mSwanApiContext);
                            this.mApis.put("1968522584", rs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(rs1Var, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Router.navigateTo")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 H = rs1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    ts1 ts1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof ts1)) {
                            ts1Var = (ts1) obj;
                        } else {
                            ts1Var = new ts1(this.mSwanApiContext);
                            this.mApis.put("1317280190", ts1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ts1Var, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Router.reLaunch")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = ts1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    us1 us1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof us1)) {
                            us1Var = (us1) obj;
                        } else {
                            us1Var = new us1(this.mSwanApiContext);
                            this.mApis.put("-420075743", us1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(us1Var, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Router.reLoadErrorPage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = us1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    ss1 ss1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof ss1)) {
                            ss1Var = (ss1) obj;
                        } else {
                            ss1Var = new ss1(this.mSwanApiContext);
                            this.mApis.put("1792515533", ss1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ss1Var, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Router.redirectTo")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 D = ss1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    rs1 rs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof rs1)) {
                            rs1Var = (rs1) obj;
                        } else {
                            rs1Var = new rs1(this.mSwanApiContext);
                            this.mApis.put("1968522584", rs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(rs1Var, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Router.showModalPage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 J = rs1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    xs1 xs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof xs1)) {
                            xs1Var = (xs1) obj;
                        } else {
                            xs1Var = new xs1(this.mSwanApiContext);
                            this.mApis.put("-594895721", xs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(xs1Var, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Setting.getAppInfoSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 F = xs1Var.F();
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    xs1 xs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof xs1)) {
                            xs1Var = (xs1) obj;
                        } else {
                            xs1Var = new xs1(this.mSwanApiContext);
                            this.mApis.put("-594895721", xs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(xs1Var, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Setting.getSetting")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 G = xs1Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    xs1 xs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof xs1)) {
                            xs1Var = (xs1) obj;
                        } else {
                            xs1Var = new xs1(this.mSwanApiContext);
                            this.mApis.put("-594895721", xs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(xs1Var, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Setting.getSlaveIdSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 H = xs1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    xs1 xs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof xs1)) {
                            xs1Var = (xs1) obj;
                        } else {
                            xs1Var = new xs1(this.mSwanApiContext);
                            this.mApis.put("-594895721", xs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(xs1Var, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Setting.getSwanId")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 I = xs1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    xs1 xs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof xs1)) {
                            xs1Var = (xs1) obj;
                        } else {
                            xs1Var = new xs1(this.mSwanApiContext);
                            this.mApis.put("-594895721", xs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(xs1Var, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Setting.getUserInfo")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 J = xs1Var.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    ws1 ws1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof ws1)) {
                            ws1Var = (ws1) obj;
                        } else {
                            ws1Var = new ws1(this.mSwanApiContext);
                            this.mApis.put("450273045", ws1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ws1Var, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Setting.isAllowedAdOpenAppSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = ws1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    v93 v93Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof v93)) {
                            v93Var = (v93) obj;
                        } else {
                            v93Var = new v93(this.mSwanApiContext);
                            this.mApis.put("712777136", v93Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(v93Var, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = v93Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    at1 at1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("-804054859", at1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(at1Var, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = at1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    at1 at1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("-804054859", at1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(at1Var, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorageSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 C = at1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    zs1 zs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("130910081", zs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(zs1Var, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.clearStorage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = zs1Var.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    zs1 zs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("130910081", zs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(zs1Var, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.clearStorageSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 C = zs1Var.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    at1 at1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("-804054859", at1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(at1Var, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.getGlobalStorage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 D = at1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    at1 at1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("-804054859", at1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(at1Var, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfo")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 G = at1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    at1 at1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("-804054859", at1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(at1Var, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfoSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 J = at1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    at1 at1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("-804054859", at1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(at1Var, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 K = at1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    zs1 zs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("130910081", zs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(zs1Var, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.getStorage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 D = zs1Var.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    zs1 zs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("130910081", zs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(zs1Var, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.getStorageInfo")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 G = zs1Var.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    zs1 zs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("130910081", zs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(zs1Var, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.getStorageInfoAsync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 H = zs1Var.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    zs1 zs1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("130910081", zs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(zs1Var, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.getStorageInfoSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 J = zs1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    zs1 zs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("130910081", zs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(zs1Var, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.getStorageSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 K = zs1Var.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    at1 at1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("-804054859", at1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(at1Var, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 R = at1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    at1 at1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("-804054859", at1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(at1Var, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorageSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 T = at1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    zs1 zs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("130910081", zs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(zs1Var, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.removeStorage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 R = zs1Var.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    zs1 zs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("130910081", zs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(zs1Var, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.removeStorageSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 T = zs1Var.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    at1 at1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("-804054859", at1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(at1Var, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.setGlobalStorage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 U = at1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    at1 at1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof at1)) {
                            at1Var = (at1) obj;
                        } else {
                            at1Var = new at1(this.mSwanApiContext);
                            this.mApis.put("-804054859", at1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(at1Var, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.setGlobalStorageSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 W = at1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    zs1 zs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("130910081", zs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(zs1Var, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.setStorage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 U = zs1Var.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    zs1 zs1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof zs1)) {
                            zs1Var = (zs1) obj;
                        } else {
                            zs1Var = new zs1(this.mSwanApiContext);
                            this.mApis.put("130910081", zs1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(zs1Var, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Storage.setStorageSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 W = zs1Var.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    ct1 ct1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof ct1)) {
                            ct1Var = (ct1) obj;
                        } else {
                            ct1Var = new ct1(this.mSwanApiContext);
                            this.mApis.put("823117982", ct1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ct1Var, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Subscription.requestSubscribeFormId")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 E = ct1Var.E(str);
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    dt1 dt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof dt1)) {
                            dt1Var = (dt1) obj;
                        } else {
                            dt1Var = new dt1(this.mSwanApiContext);
                            this.mApis.put("-947445811", dt1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(dt1Var, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Subscription.subscribeService")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 F = dt1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    kt1 kt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof kt1)) {
                            kt1Var = (kt1) obj;
                        } else {
                            kt1Var = new kt1(this.mSwanApiContext);
                            this.mApis.put("1936205521", kt1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(kt1Var, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.exitFullScreen")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = kt1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    gt1 gt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof gt1)) {
                            gt1Var = (gt1) obj;
                        } else {
                            gt1Var = new gt1(this.mSwanApiContext);
                            this.mApis.put("99997465", gt1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(gt1Var, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.getBrightness")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = gt1Var.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    ht1 ht1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof ht1)) {
                            ht1Var = (ht1) obj;
                        } else {
                            ht1Var = new ht1(this.mSwanApiContext);
                            this.mApis.put("-518757484", ht1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ht1Var, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.getClipboardData")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = ht1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    jt1 jt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof jt1)) {
                            jt1Var = (jt1) obj;
                        } else {
                            jt1Var = new jt1(this.mSwanApiContext);
                            this.mApis.put("1694151270", jt1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(jt1Var, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.getDeviceInfo")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = jt1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    lt1 lt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof lt1)) {
                            lt1Var = (lt1) obj;
                        } else {
                            lt1Var = new lt1(this.mSwanApiContext);
                            this.mApis.put("-1321681619", lt1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(lt1Var, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.getDeviceProfile")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = lt1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    rt1 rt1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof rt1)) {
                            rt1Var = (rt1) obj;
                        } else {
                            rt1Var = new rt1(this.mSwanApiContext);
                            this.mApis.put("447234992", rt1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(rt1Var, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.getMediaVolume")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = rt1Var.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    mt1 mt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof mt1)) {
                            mt1Var = (mt1) obj;
                        } else {
                            mt1Var = new mt1(this.mSwanApiContext);
                            this.mApis.put("-1569246082", mt1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(mt1Var, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.makePhoneCall")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = mt1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    ot1 ot1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof ot1)) {
                            ot1Var = (ot1) obj;
                        } else {
                            ot1Var = new ot1(this.mSwanApiContext);
                            this.mApis.put("1099851202", ot1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ot1Var, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.openSMSPanel")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = ot1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    nt1 nt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof nt1)) {
                            nt1Var = (nt1) obj;
                        } else {
                            nt1Var = new nt1(this.mSwanApiContext);
                            this.mApis.put("-1707203360", nt1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(nt1Var, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.requestFullScreen")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 F = nt1Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    ht1 ht1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof ht1)) {
                            ht1Var = (ht1) obj;
                        } else {
                            ht1Var = new ht1(this.mSwanApiContext);
                            this.mApis.put("-518757484", ht1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ht1Var, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.setClipboardData")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = ht1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    rs2 rs2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof rs2)) {
                            rs2Var = (rs2) obj;
                        } else {
                            rs2Var = new rs2(this.mSwanApiContext);
                            this.mApis.put("1161486049", rs2Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(rs2Var, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.setErrorPageType")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = rs2Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    rt1 rt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof rt1)) {
                            rt1Var = (rt1) obj;
                        } else {
                            rt1Var = new rt1(this.mSwanApiContext);
                            this.mApis.put("447234992", rt1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(rt1Var, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.setMediaVolume")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 z = rt1Var.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    ft1 ft1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("1372680763", ft1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ft1Var, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.startAccelerometer")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = ft1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    it1 it1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof it1)) {
                            it1Var = (it1) obj;
                        } else {
                            it1Var = new it1(this.mSwanApiContext);
                            this.mApis.put("1689255576", it1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(it1Var, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.startCompass")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = it1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    ft1 ft1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof ft1)) {
                            ft1Var = (ft1) obj;
                        } else {
                            ft1Var = new ft1(this.mSwanApiContext);
                            this.mApis.put("1372680763", ft1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ft1Var, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.stopAccelerometer")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 B = ft1Var.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    it1 it1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof it1)) {
                            it1Var = (it1) obj;
                        } else {
                            it1Var = new it1(this.mSwanApiContext);
                            this.mApis.put("1689255576", it1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(it1Var, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "System.stopCompass")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 z = it1Var.z();
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    cu1 cu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof cu1)) {
                            cu1Var = (cu1) obj;
                        } else {
                            cu1Var = new cu1(this.mSwanApiContext);
                            this.mApis.put("201194468", cu1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(cu1Var, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.addToDesktop")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 B = cu1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    yt1 yt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof yt1)) {
                            yt1Var = (yt1) obj;
                        } else {
                            yt1Var = new yt1(this.mSwanApiContext);
                            this.mApis.put("-1412306947", yt1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(yt1Var, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.calcMD5")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = yt1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    zt1 zt1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof zt1)) {
                            zt1Var = (zt1) obj;
                        } else {
                            zt1Var = new zt1(this.mSwanApiContext);
                            this.mApis.put("1626415364", zt1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(zt1Var, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.checkAppInstalled")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = zt1Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    bu1 bu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof bu1)) {
                            bu1Var = (bu1) obj;
                        } else {
                            bu1Var = new bu1(this.mSwanApiContext);
                            this.mApis.put("-836768778", bu1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(bu1Var, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfo")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = bu1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    hu1 hu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", hu1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(hu1Var, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfoSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 E = hu1Var.E();
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    du1 du1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof du1)) {
                            du1Var = (du1) obj;
                        } else {
                            du1Var = new du1(this.mSwanApiContext);
                            this.mApis.put("-810858308", du1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(du1Var, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.getPerformanceLevel")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = du1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    hu1 hu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", hu1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(hu1Var, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.getSystemInfo")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 H = hu1Var.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    hu1 hu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", hu1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(hu1Var, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.getSystemInfoAsync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 I = hu1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    hu1 hu1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof hu1)) {
                            hu1Var = (hu1) obj;
                        } else {
                            hu1Var = new hu1(this.mSwanApiContext);
                            this.mApis.put("-1011537871", hu1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(hu1Var, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.getSystemInfoSync")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 J = hu1Var.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    eu1 eu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof eu1)) {
                            eu1Var = (eu1) obj;
                        } else {
                            eu1Var = new eu1(this.mSwanApiContext);
                            this.mApis.put("-2097727681", eu1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(eu1Var, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.handleException")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = eu1Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    au1 au1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof au1)) {
                            au1Var = (au1) obj;
                        } else {
                            au1Var = new au1(this.mSwanApiContext);
                            this.mApis.put("2084449317", au1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(au1Var, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.hasCloseHandler")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = au1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    d73 d73Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof d73)) {
                            d73Var = (d73) obj;
                        } else {
                            d73Var = new d73(this.mSwanApiContext);
                            this.mApis.put("1031678042", d73Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(d73Var, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.hideCaptureScreenShareDialog")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 x = d73Var.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    fu1 fu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof fu1)) {
                            fu1Var = (fu1) obj;
                        } else {
                            fu1Var = new fu1(this.mSwanApiContext);
                            this.mApis.put("1751900130", fu1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(fu1Var, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.logToFile")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = fu1Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    e63 e63Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof e63)) {
                            e63Var = (e63) obj;
                        } else {
                            e63Var = new e63(this.mSwanApiContext);
                            this.mApis.put("1748196865", e63Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(e63Var, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.preloadPackage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = e63Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    gu1 gu1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof gu1)) {
                            gu1Var = (gu1) obj;
                        } else {
                            gu1Var = new gu1(this.mSwanApiContext);
                            this.mApis.put("589529211", gu1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(gu1Var, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.previewImage")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 B = gu1Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    ju1 ju1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof ju1)) {
                            ju1Var = (ju1) obj;
                        } else {
                            ju1Var = new ju1(this.mSwanApiContext);
                            this.mApis.put("-577481801", ju1Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(ju1Var, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Utils.ubcFlowJar")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 I = ju1Var.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public zq1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {zq1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = zq1Var;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    od3 od3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof od3)) {
                            od3Var = (od3) obj;
                        } else {
                            od3Var = new od3(this.mSwanApiContext);
                            this.mApis.put("1879401452", od3Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(od3Var, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Wifi.connectWifi")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 A = od3Var.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    od3 od3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof od3)) {
                            od3Var = (od3) obj;
                        } else {
                            od3Var = new od3(this.mSwanApiContext);
                            this.mApis.put("1879401452", od3Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(od3Var, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Wifi.getConnectedWifi")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 B = od3Var.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    od3 od3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof od3)) {
                            od3Var = (od3) obj;
                        } else {
                            od3Var = new od3(this.mSwanApiContext);
                            this.mApis.put("1879401452", od3Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(od3Var, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Wifi.getWifiList")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 C = od3Var.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    od3 od3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof od3)) {
                            od3Var = (od3) obj;
                        } else {
                            od3Var = new od3(this.mSwanApiContext);
                            this.mApis.put("1879401452", od3Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(od3Var, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Wifi.startWifi")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 G = od3Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    od3 od3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof od3)) {
                            od3Var = (od3) obj;
                        } else {
                            od3Var = new od3(this.mSwanApiContext);
                            this.mApis.put("1879401452", od3Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(od3Var, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "Wifi.stopWifi")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 H = od3Var.H(str);
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
