package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
import com.baidu.tieba.a02;
import com.baidu.tieba.ax1;
import com.baidu.tieba.ay1;
import com.baidu.tieba.az1;
import com.baidu.tieba.b02;
import com.baidu.tieba.bd3;
import com.baidu.tieba.bz1;
import com.baidu.tieba.c02;
import com.baidu.tieba.cc3;
import com.baidu.tieba.cx1;
import com.baidu.tieba.d02;
import com.baidu.tieba.db2;
import com.baidu.tieba.dx1;
import com.baidu.tieba.dy1;
import com.baidu.tieba.dz1;
import com.baidu.tieba.e02;
import com.baidu.tieba.e43;
import com.baidu.tieba.ex1;
import com.baidu.tieba.ez1;
import com.baidu.tieba.f02;
import com.baidu.tieba.fx1;
import com.baidu.tieba.fz1;
import com.baidu.tieba.gx1;
import com.baidu.tieba.gz1;
import com.baidu.tieba.h02;
import com.baidu.tieba.hz1;
import com.baidu.tieba.ix1;
import com.baidu.tieba.iz1;
import com.baidu.tieba.j13;
import com.baidu.tieba.jy1;
import com.baidu.tieba.jz1;
import com.baidu.tieba.kx1;
import com.baidu.tieba.ky1;
import com.baidu.tieba.kz1;
import com.baidu.tieba.lx1;
import com.baidu.tieba.lz1;
import com.baidu.tieba.mj3;
import com.baidu.tieba.mw1;
import com.baidu.tieba.mz1;
import com.baidu.tieba.np1;
import com.baidu.tieba.ny2;
import com.baidu.tieba.ox1;
import com.baidu.tieba.oy1;
import com.baidu.tieba.pb2;
import com.baidu.tieba.py1;
import com.baidu.tieba.py2;
import com.baidu.tieba.pz1;
import com.baidu.tieba.qx1;
import com.baidu.tieba.qy1;
import com.baidu.tieba.rx1;
import com.baidu.tieba.ry1;
import com.baidu.tieba.rz1;
import com.baidu.tieba.sx1;
import com.baidu.tieba.sy1;
import com.baidu.tieba.t13;
import com.baidu.tieba.tf3;
import com.baidu.tieba.tx1;
import com.baidu.tieba.u02;
import com.baidu.tieba.ux1;
import com.baidu.tieba.uy1;
import com.baidu.tieba.v02;
import com.baidu.tieba.vx1;
import com.baidu.tieba.vy1;
import com.baidu.tieba.w02;
import com.baidu.tieba.wx1;
import com.baidu.tieba.wz1;
import com.baidu.tieba.x02;
import com.baidu.tieba.xc2;
import com.baidu.tieba.xw1;
import com.baidu.tieba.xx1;
import com.baidu.tieba.xy1;
import com.baidu.tieba.xz1;
import com.baidu.tieba.yx1;
import com.baidu.tieba.yy1;
import com.baidu.tieba.yz1;
import com.baidu.tieba.zk3;
import com.baidu.tieba.zl2;
import com.baidu.tieba.zw1;
import com.baidu.tieba.zx1;
import com.baidu.tieba.zz1;
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
/* loaded from: classes3.dex */
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

    public static Map<String, Object> getV8ApiModules(final xw1 xw1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, xw1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    dx1 dx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof dx1)) {
                            dx1Var = (dx1) obj;
                        } else {
                            dx1Var = new dx1(this.mSwanApiContext);
                            this.mApis.put("1930258908", dx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(dx1Var, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Account.checkSession")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = dx1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    ex1 ex1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ex1)) {
                            ex1Var = (ex1) obj;
                        } else {
                            ex1Var = new ex1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ex1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ex1Var, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Account.getLoginCode")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 C = ex1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    fx1 fx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof fx1)) {
                            fx1Var = (fx1) obj;
                        } else {
                            fx1Var = new fx1(this.mSwanApiContext);
                            this.mApis.put("1754780133", fx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(fx1Var, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Account.getOpenId")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = fx1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    mw1 mw1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof mw1)) {
                            mw1Var = (mw1) obj;
                        } else {
                            mw1Var = new mw1(this.mSwanApiContext);
                            this.mApis.put("-343998465", mw1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(mw1Var, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Account.getUnionBDUSS")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = mw1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    ex1 ex1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ex1)) {
                            ex1Var = (ex1) obj;
                        } else {
                            ex1Var = new ex1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ex1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ex1Var, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Account.login")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 I = ex1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    cx1 cx1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof cx1)) {
                            cx1Var = (cx1) obj;
                        } else {
                            cx1Var = new cx1(this.mSwanApiContext);
                            this.mApis.put("-337742792", cx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(cx1Var, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Account.isBaiduAccountSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = cx1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    ex1 ex1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ex1)) {
                            ex1Var = (ex1) obj;
                        } else {
                            ex1Var = new ex1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ex1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ex1Var, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Account.isLoginSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 H = ex1Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    gx1 gx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof gx1)) {
                            gx1Var = (gx1) obj;
                        } else {
                            gx1Var = new gx1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", gx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(gx1Var, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Basic.loadSubPackage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 F = gx1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    gx1 gx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof gx1)) {
                            gx1Var = (gx1) obj;
                        } else {
                            gx1Var = new gx1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", gx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(gx1Var, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Basic.loadSubPackages")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 G = gx1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    np1 np1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof np1)) {
                            np1Var = (np1) obj;
                        } else {
                            np1Var = new np1(this.mSwanApiContext);
                            this.mApis.put("1460300387", np1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(np1Var, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Bookshelf.deleteBookshelf")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 K = np1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    np1 np1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof np1)) {
                            np1Var = (np1) obj;
                        } else {
                            np1Var = new np1(this.mSwanApiContext);
                            this.mApis.put("1460300387", np1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(np1Var, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Bookshelf.insertBookshelf")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 P = np1Var.P(str);
                        if (P == null) {
                            return "";
                        }
                        return P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    np1 np1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof np1)) {
                            np1Var = (np1) obj;
                        } else {
                            np1Var = new np1(this.mSwanApiContext);
                            this.mApis.put("1460300387", np1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(np1Var, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Bookshelf.navigateToBookshelf")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 U = np1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    np1 np1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof np1)) {
                            np1Var = (np1) obj;
                        } else {
                            np1Var = new np1(this.mSwanApiContext);
                            this.mApis.put("1460300387", np1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(np1Var, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Bookshelf.queryBookshelf")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 V = np1Var.V(str);
                        if (V == null) {
                            return "";
                        }
                        return V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    np1 np1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof np1)) {
                            np1Var = (np1) obj;
                        } else {
                            np1Var = new np1(this.mSwanApiContext);
                            this.mApis.put("1460300387", np1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(np1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Bookshelf.updateBookshelfReadTime")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 X = np1Var.X(str);
                        if (X == null) {
                            return "";
                        }
                        return X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    ax1 ax1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof ax1)) {
                            ax1Var = (ax1) obj;
                        } else {
                            ax1Var = new ax1(this.mSwanApiContext);
                            this.mApis.put("-277316359", ax1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ax1Var, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Coupon.getPlatformCoupons")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = ax1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    ax1 ax1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof ax1)) {
                            ax1Var = (ax1) obj;
                        } else {
                            ax1Var = new ax1(this.mSwanApiContext);
                            this.mApis.put("-277316359", ax1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ax1Var, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Coupon.getUserCoupons")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 z = ax1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    ax1 ax1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof ax1)) {
                            ax1Var = (ax1) obj;
                        } else {
                            ax1Var = new ax1(this.mSwanApiContext);
                            this.mApis.put("-277316359", ax1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ax1Var, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Coupon.takeCoupons")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 C = ax1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    ix1 ix1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof ix1)) {
                            ix1Var = (ix1) obj;
                        } else {
                            ix1Var = new ix1(this.mSwanApiContext);
                            this.mApis.put("-1225406515", ix1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ix1Var, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Favorite.getFavorStatus")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = ix1Var.x(str);
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
                        Pair<Boolean, v02> a = x02.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Favorite.showFavoriteGuide")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 G = showFavoriteGuideApi.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    kx1 kx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof kx1)) {
                            kx1Var = (kx1) obj;
                        } else {
                            kx1Var = new kx1(this.mSwanApiContext);
                            this.mApis.put("-2057135077", kx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(kx1Var, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "File.shareFile")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = kx1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    zl2 zl2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof zl2)) {
                            zl2Var = (zl2) obj;
                        } else {
                            zl2Var = new zl2(this.mSwanApiContext);
                            this.mApis.put("2077414795", zl2Var);
                        }
                        Pair<Boolean, v02> a = x02.a(zl2Var, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = zl2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    zl2 zl2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof zl2)) {
                            zl2Var = (zl2) obj;
                        } else {
                            zl2Var = new zl2(this.mSwanApiContext);
                            this.mApis.put("2077414795", zl2Var);
                        }
                        Pair<Boolean, v02> a = x02.a(zl2Var, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessageSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = zl2Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String download(String str) {
                    lx1 lx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof lx1)) {
                            lx1Var = (lx1) obj;
                        } else {
                            lx1Var = new lx1(this.mSwanApiContext);
                            this.mApis.put("-170124576", lx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(lx1Var, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "HostDownloadManager.download")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = lx1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    lx1 lx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof lx1)) {
                            lx1Var = (lx1) obj;
                        } else {
                            lx1Var = new lx1(this.mSwanApiContext);
                            this.mApis.put("-170124576", lx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(lx1Var, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "HostDownloadManager.openFile")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 z = lx1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    lx1 lx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof lx1)) {
                            lx1Var = (lx1) obj;
                        } else {
                            lx1Var = new lx1(this.mSwanApiContext);
                            this.mApis.put("-170124576", lx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(lx1Var, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "HostDownloadManager.query")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 query = lx1Var.query(str);
                        if (query == null) {
                            return "";
                        }
                        return query.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    lx1 lx1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof lx1)) {
                            lx1Var = (lx1) obj;
                        } else {
                            lx1Var = new lx1(this.mSwanApiContext);
                            this.mApis.put("-170124576", lx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(lx1Var, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "HostDownloadManager.openDownloadCenter")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = lx1Var.y();
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naImage", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    ny2 ny2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof ny2)) {
                            ny2Var = (ny2) obj;
                        } else {
                            ny2Var = new ny2(this.mSwanApiContext);
                            this.mApis.put("1445003743", ny2Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ny2Var, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Image.callImageMenu")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = ny2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    ox1 ox1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof ox1)) {
                            ox1Var = (ox1) obj;
                        } else {
                            ox1Var = new ox1(this.mSwanApiContext);
                            this.mApis.put("-1252730367", ox1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ox1Var, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Image.compressImage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = ox1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    wx1 wx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof wx1)) {
                            wx1Var = (wx1) obj;
                        } else {
                            wx1Var = new wx1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", wx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(wx1Var, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.closeTabBar")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = wx1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    wx1 wx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof wx1)) {
                            wx1Var = (wx1) obj;
                        } else {
                            wx1Var = new wx1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", wx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(wx1Var, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.closeTabBarRedDot")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = wx1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    sx1 sx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof sx1)) {
                            sx1Var = (sx1) obj;
                        } else {
                            sx1Var = new sx1(this.mSwanApiContext);
                            this.mApis.put("-246386074", sx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(sx1Var, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.hideNavigationBarLoading")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = sx1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    ux1 ux1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ux1)) {
                            ux1Var = (ux1) obj;
                        } else {
                            ux1Var = new ux1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ux1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ux1Var, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.openMultiPicker")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 G = ux1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    ux1 ux1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ux1)) {
                            ux1Var = (ux1) obj;
                        } else {
                            ux1Var = new ux1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ux1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ux1Var, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.openPicker")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 H = ux1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    wx1 wx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof wx1)) {
                            wx1Var = (wx1) obj;
                        } else {
                            wx1Var = new wx1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", wx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(wx1Var, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.openTabBar")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 C = wx1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    tx1 tx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof tx1)) {
                            tx1Var = (tx1) obj;
                        } else {
                            tx1Var = new tx1(this.mSwanApiContext);
                            this.mApis.put("-1750613704", tx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(tx1Var, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.pageScrollTo")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = tx1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    sx1 sx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof sx1)) {
                            sx1Var = (sx1) obj;
                        } else {
                            sx1Var = new sx1(this.mSwanApiContext);
                            this.mApis.put("-246386074", sx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(sx1Var, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarColor")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 z = sx1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    sx1 sx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof sx1)) {
                            sx1Var = (sx1) obj;
                        } else {
                            sx1Var = new sx1(this.mSwanApiContext);
                            this.mApis.put("-246386074", sx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(sx1Var, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarTitle")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = sx1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    wx1 wx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof wx1)) {
                            wx1Var = (wx1) obj;
                        } else {
                            wx1Var = new wx1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", wx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(wx1Var, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.setTabBarItem")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 D = wx1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    ux1 ux1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ux1)) {
                            ux1Var = (ux1) obj;
                        } else {
                            ux1Var = new ux1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ux1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ux1Var, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.showDatePickerView")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 L = ux1Var.L(str);
                        if (L == null) {
                            return "";
                        }
                        return L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    yx1 yx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof yx1)) {
                            yx1Var = (yx1) obj;
                        } else {
                            yx1Var = new yx1(this.mSwanApiContext);
                            this.mApis.put("1172469410", yx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(yx1Var, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.showHalfScreenWebview")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 K = yx1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    qx1 qx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof qx1)) {
                            qx1Var = (qx1) obj;
                        } else {
                            qx1Var = new qx1(this.mSwanApiContext);
                            this.mApis.put("5236036", qx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(qx1Var, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.showLoading")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = qx1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    rx1 rx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof rx1)) {
                            rx1Var = (rx1) obj;
                        } else {
                            rx1Var = new rx1(this.mSwanApiContext);
                            this.mApis.put("1913747800", rx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(rx1Var, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.showModal")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = rx1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    sx1 sx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof sx1)) {
                            sx1Var = (sx1) obj;
                        } else {
                            sx1Var = new sx1(this.mSwanApiContext);
                            this.mApis.put("-246386074", sx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(sx1Var, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.showNavigationBarLoading")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 B = sx1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    xx1 xx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof xx1)) {
                            xx1Var = (xx1) obj;
                        } else {
                            xx1Var = new xx1(this.mSwanApiContext);
                            this.mApis.put("1159492510", xx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xx1Var, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.showToast")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 Q = xx1Var.Q(str);
                        if (Q == null) {
                            return "";
                        }
                        return Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    vx1 vx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof vx1)) {
                            vx1Var = (vx1) obj;
                        } else {
                            vx1Var = new vx1(this.mSwanApiContext);
                            this.mApis.put("1165118609", vx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(vx1Var, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.stopPullDownRefresh")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = vx1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    ux1 ux1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ux1)) {
                            ux1Var = (ux1) obj;
                        } else {
                            ux1Var = new ux1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ux1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ux1Var, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.updateMultiPicker")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 M = ux1Var.M(str);
                        if (M == null) {
                            return "";
                        }
                        return M.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    qx1 qx1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof qx1)) {
                            qx1Var = (qx1) obj;
                        } else {
                            qx1Var = new qx1(this.mSwanApiContext);
                            this.mApis.put("5236036", qx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(qx1Var, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.hideLoading")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = qx1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    xx1 xx1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof xx1)) {
                            xx1Var = (xx1) obj;
                        } else {
                            xx1Var = new xx1(this.mSwanApiContext);
                            this.mApis.put("1159492510", xx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xx1Var, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.hideToast")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 K = xx1Var.K();
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    zx1 zx1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof zx1)) {
                            zx1Var = (zx1) obj;
                        } else {
                            zx1Var = new zx1(this.mSwanApiContext);
                            this.mApis.put("-137346255", zx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(zx1Var, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Keyboard.startKeyboardHeightChange")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 C = zx1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    zx1 zx1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof zx1)) {
                            zx1Var = (zx1) obj;
                        } else {
                            zx1Var = new zx1(this.mSwanApiContext);
                            this.mApis.put("-137346255", zx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(zx1Var, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Keyboard.stopKeyboardHeightChange")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 D = zx1Var.D();
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    ay1 ay1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof ay1)) {
                            ay1Var = (ay1) obj;
                        } else {
                            ay1Var = new ay1(this.mSwanApiContext);
                            this.mApis.put("-397373095", ay1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ay1Var, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "LocationService.getLocation")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = ay1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    ay1 ay1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof ay1)) {
                            ay1Var = (ay1) obj;
                        } else {
                            ay1Var = new ay1(this.mSwanApiContext);
                            this.mApis.put("-397373095", ay1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ay1Var, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "LocationService.startLocationUpdate")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = ay1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    ay1 ay1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof ay1)) {
                            ay1Var = (ay1) obj;
                        } else {
                            ay1Var = new ay1(this.mSwanApiContext);
                            this.mApis.put("-397373095", ay1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ay1Var, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "LocationService.stopLocationUpdate")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 B = ay1Var.B();
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    rz1 rz1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof rz1)) {
                            rz1Var = (rz1) obj;
                        } else {
                            rz1Var = new rz1(this.mSwanApiContext);
                            this.mApis.put("538070032", rz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(rz1Var, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = rz1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String callService(String str) {
                    dy1 dy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof dy1)) {
                            dy1Var = (dy1) obj;
                        } else {
                            dy1Var = new dy1(this.mSwanApiContext);
                            this.mApis.put("-1076509454", dy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(dy1Var, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Network.callService")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = dy1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    ky1 ky1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof ky1)) {
                            ky1Var = (ky1) obj;
                        } else {
                            ky1Var = new ky1(this.mSwanApiContext);
                            this.mApis.put("968563034", ky1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ky1Var, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Network.cancelRequest")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 D = ky1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    jy1 jy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof jy1)) {
                            jy1Var = (jy1) obj;
                        } else {
                            jy1Var = new jy1(this.mSwanApiContext);
                            this.mApis.put("453220699", jy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(jy1Var, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Network.networkStatusChange")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = jy1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    jy1 jy1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof jy1)) {
                            jy1Var = (jy1) obj;
                        } else {
                            jy1Var = new jy1(this.mSwanApiContext);
                            this.mApis.put("453220699", jy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(jy1Var, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Network.getNetworkType")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = jy1Var.x();
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
                    ky1 ky1Var;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, jsObject)) == null) {
                        try {
                            u02.c().a("request");
                            Object obj = this.mApis.get("968563034");
                            if (obj != null && (obj instanceof ky1)) {
                                ky1Var = (ky1) obj;
                            } else {
                                ky1Var = new ky1(this.mSwanApiContext);
                                this.mApis.put("968563034", ky1Var);
                            }
                            Pair<Boolean, v02> a2 = x02.a(ky1Var, "swanAPI/request");
                            if (((Boolean) a2.first).booleanValue()) {
                                a = ((v02) a2.second).a();
                            } else if (db2.a(this.mSwanApiContext.f(), "Network.request")) {
                                a = new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            } else {
                                Pair<v02, JSONObject> t = zw1.t(jsObject);
                                if (!((v02) t.first).isSuccess()) {
                                    a = ((v02) t.first).a();
                                } else {
                                    JSONObject jSONObject = (JSONObject) t.second;
                                    if (jSONObject == null) {
                                        a = v02.a.a();
                                    } else {
                                        w02 V = ky1Var.V(jSONObject);
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
            hashMap.put("_naPayment", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    t13 t13Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof t13)) {
                            t13Var = (t13) obj;
                        } else {
                            t13Var = new t13(this.mSwanApiContext);
                            this.mApis.put("-336396851", t13Var);
                        }
                        Pair<Boolean, v02> a = x02.a(t13Var, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Payment.chooseCoupon")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = t13Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    t13 t13Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof t13)) {
                            t13Var = (t13) obj;
                        } else {
                            t13Var = new t13(this.mSwanApiContext);
                            this.mApis.put("-336396851", t13Var);
                        }
                        Pair<Boolean, v02> a = x02.a(t13Var, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Payment.getPaymentInfo")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = t13Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    j13 j13Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof j13)) {
                            j13Var = (j13) obj;
                        } else {
                            j13Var = new j13(this.mSwanApiContext);
                            this.mApis.put("1854689529", j13Var);
                        }
                        Pair<Boolean, v02> a = x02.a(j13Var, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Payment.requestThirdPayment")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = j13Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    t13 t13Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof t13)) {
                            t13Var = (t13) obj;
                        } else {
                            t13Var = new t13(this.mSwanApiContext);
                            this.mApis.put("-336396851", t13Var);
                        }
                        Pair<Boolean, v02> a = x02.a(t13Var, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Payment.setPaymentInfo")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 z = t13Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    e43 e43Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof e43)) {
                            e43Var = (e43) obj;
                        } else {
                            e43Var = new e43(this.mSwanApiContext);
                            this.mApis.put("-254510461", e43Var);
                        }
                        Pair<Boolean, v02> a = x02.a(e43Var, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Plugin.invokePluginChooseAddress")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = e43Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    e43 e43Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof e43)) {
                            e43Var = (e43) obj;
                        } else {
                            e43Var = new e43(this.mSwanApiContext);
                            this.mApis.put("-254510461", e43Var);
                        }
                        Pair<Boolean, v02> a = x02.a(e43Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 z = e43Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    e43 e43Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof e43)) {
                            e43Var = (e43) obj;
                        } else {
                            e43Var = new e43(this.mSwanApiContext);
                            this.mApis.put("-254510461", e43Var);
                        }
                        Pair<Boolean, v02> a = x02.a(e43Var, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Plugin.invokePluginPayment")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = e43Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    xc2 xc2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof xc2)) {
                            xc2Var = (xc2) obj;
                        } else {
                            xc2Var = new xc2(this.mSwanApiContext);
                            this.mApis.put("-2068479848", xc2Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xc2Var, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Prefetch.prefetchResources")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = xc2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    pb2 pb2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof pb2)) {
                            pb2Var = (pb2) obj;
                        } else {
                            pb2Var = new pb2(this.mSwanApiContext);
                            this.mApis.put("423661539", pb2Var);
                        }
                        Pair<Boolean, v02> a = x02.a(pb2Var, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Preload.preloadStatus")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = pb2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    zk3 zk3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof zk3)) {
                            zk3Var = (zk3) obj;
                        } else {
                            zk3Var = new zk3(this.mSwanApiContext);
                            this.mApis.put("-1929343869", zk3Var);
                        }
                        Pair<Boolean, v02> a = x02.a(zk3Var, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "PrivateFile.uploadFileToBos")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 C = zk3Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    oy1 oy1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof oy1)) {
                            oy1Var = (oy1) obj;
                        } else {
                            oy1Var = new oy1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", oy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(oy1Var, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Router.hideModalPage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = oy1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    oy1 oy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof oy1)) {
                            oy1Var = (oy1) obj;
                        } else {
                            oy1Var = new oy1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", oy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(oy1Var, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Router.navigateBack")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 B = oy1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    py1 py1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof py1)) {
                            py1Var = (py1) obj;
                        } else {
                            py1Var = new py1(this.mSwanApiContext);
                            this.mApis.put("1968522584", py1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(py1Var, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Router.navigateTo")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 H = py1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    ry1 ry1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof ry1)) {
                            ry1Var = (ry1) obj;
                        } else {
                            ry1Var = new ry1(this.mSwanApiContext);
                            this.mApis.put("1317280190", ry1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ry1Var, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Router.reLaunch")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = ry1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    sy1 sy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof sy1)) {
                            sy1Var = (sy1) obj;
                        } else {
                            sy1Var = new sy1(this.mSwanApiContext);
                            this.mApis.put("-420075743", sy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(sy1Var, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Router.reLoadErrorPage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = sy1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    qy1 qy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof qy1)) {
                            qy1Var = (qy1) obj;
                        } else {
                            qy1Var = new qy1(this.mSwanApiContext);
                            this.mApis.put("1792515533", qy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(qy1Var, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Router.redirectTo")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 D = qy1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    py1 py1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof py1)) {
                            py1Var = (py1) obj;
                        } else {
                            py1Var = new py1(this.mSwanApiContext);
                            this.mApis.put("1968522584", py1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(py1Var, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Router.showModalPage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 J = py1Var.J(str);
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    vy1 vy1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof vy1)) {
                            vy1Var = (vy1) obj;
                        } else {
                            vy1Var = new vy1(this.mSwanApiContext);
                            this.mApis.put("-594895721", vy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(vy1Var, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Setting.getAppInfoSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 F = vy1Var.F();
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    vy1 vy1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof vy1)) {
                            vy1Var = (vy1) obj;
                        } else {
                            vy1Var = new vy1(this.mSwanApiContext);
                            this.mApis.put("-594895721", vy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(vy1Var, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Setting.getSlaveIdSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 H = vy1Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    uy1 uy1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof uy1)) {
                            uy1Var = (uy1) obj;
                        } else {
                            uy1Var = new uy1(this.mSwanApiContext);
                            this.mApis.put("450273045", uy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(uy1Var, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Setting.isAllowedAdOpenAppSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = uy1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    vy1 vy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof vy1)) {
                            vy1Var = (vy1) obj;
                        } else {
                            vy1Var = new vy1(this.mSwanApiContext);
                            this.mApis.put("-594895721", vy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(vy1Var, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Setting.getSetting")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 G = vy1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    vy1 vy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof vy1)) {
                            vy1Var = (vy1) obj;
                        } else {
                            vy1Var = new vy1(this.mSwanApiContext);
                            this.mApis.put("-594895721", vy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(vy1Var, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Setting.getSwanId")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 I = vy1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    vy1 vy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof vy1)) {
                            vy1Var = (vy1) obj;
                        } else {
                            vy1Var = new vy1(this.mSwanApiContext);
                            this.mApis.put("-594895721", vy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(vy1Var, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Setting.getUserInfo")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 J = vy1Var.J(str);
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    tf3 tf3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof tf3)) {
                            tf3Var = (tf3) obj;
                        } else {
                            tf3Var = new tf3(this.mSwanApiContext);
                            this.mApis.put("712777136", tf3Var);
                        }
                        Pair<Boolean, v02> a = x02.a(tf3Var, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = tf3Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    yy1 yy1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof yy1)) {
                            yy1Var = (yy1) obj;
                        } else {
                            yy1Var = new yy1(this.mSwanApiContext);
                            this.mApis.put("-804054859", yy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(yy1Var, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = yy1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    yy1 yy1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof yy1)) {
                            yy1Var = (yy1) obj;
                        } else {
                            yy1Var = new yy1(this.mSwanApiContext);
                            this.mApis.put("-804054859", yy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(yy1Var, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorageSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 C = yy1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    xy1 xy1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof xy1)) {
                            xy1Var = (xy1) obj;
                        } else {
                            xy1Var = new xy1(this.mSwanApiContext);
                            this.mApis.put("130910081", xy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xy1Var, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.clearStorage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = xy1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    xy1 xy1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof xy1)) {
                            xy1Var = (xy1) obj;
                        } else {
                            xy1Var = new xy1(this.mSwanApiContext);
                            this.mApis.put("130910081", xy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xy1Var, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.clearStorageSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 C = xy1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    yy1 yy1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof yy1)) {
                            yy1Var = (yy1) obj;
                        } else {
                            yy1Var = new yy1(this.mSwanApiContext);
                            this.mApis.put("-804054859", yy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(yy1Var, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfo")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 G = yy1Var.G();
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    yy1 yy1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof yy1)) {
                            yy1Var = (yy1) obj;
                        } else {
                            yy1Var = new yy1(this.mSwanApiContext);
                            this.mApis.put("-804054859", yy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(yy1Var, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfoSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 J = yy1Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    xy1 xy1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof xy1)) {
                            xy1Var = (xy1) obj;
                        } else {
                            xy1Var = new xy1(this.mSwanApiContext);
                            this.mApis.put("130910081", xy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xy1Var, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.getStorageInfo")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 G = xy1Var.G();
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    xy1 xy1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof xy1)) {
                            xy1Var = (xy1) obj;
                        } else {
                            xy1Var = new xy1(this.mSwanApiContext);
                            this.mApis.put("130910081", xy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xy1Var, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.getStorageInfoSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 J = xy1Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    yy1 yy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof yy1)) {
                            yy1Var = (yy1) obj;
                        } else {
                            yy1Var = new yy1(this.mSwanApiContext);
                            this.mApis.put("-804054859", yy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(yy1Var, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 D = yy1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    yy1 yy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof yy1)) {
                            yy1Var = (yy1) obj;
                        } else {
                            yy1Var = new yy1(this.mSwanApiContext);
                            this.mApis.put("-804054859", yy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(yy1Var, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 K = yy1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    xy1 xy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof xy1)) {
                            xy1Var = (xy1) obj;
                        } else {
                            xy1Var = new xy1(this.mSwanApiContext);
                            this.mApis.put("130910081", xy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xy1Var, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.getStorage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 D = xy1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    xy1 xy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof xy1)) {
                            xy1Var = (xy1) obj;
                        } else {
                            xy1Var = new xy1(this.mSwanApiContext);
                            this.mApis.put("130910081", xy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xy1Var, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.getStorageInfoAsync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 H = xy1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    xy1 xy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof xy1)) {
                            xy1Var = (xy1) obj;
                        } else {
                            xy1Var = new xy1(this.mSwanApiContext);
                            this.mApis.put("130910081", xy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xy1Var, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.getStorageSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 K = xy1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    yy1 yy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof yy1)) {
                            yy1Var = (yy1) obj;
                        } else {
                            yy1Var = new yy1(this.mSwanApiContext);
                            this.mApis.put("-804054859", yy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(yy1Var, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 R = yy1Var.R(str);
                        if (R == null) {
                            return "";
                        }
                        return R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    yy1 yy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof yy1)) {
                            yy1Var = (yy1) obj;
                        } else {
                            yy1Var = new yy1(this.mSwanApiContext);
                            this.mApis.put("-804054859", yy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(yy1Var, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorageSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 T = yy1Var.T(str);
                        if (T == null) {
                            return "";
                        }
                        return T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    xy1 xy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof xy1)) {
                            xy1Var = (xy1) obj;
                        } else {
                            xy1Var = new xy1(this.mSwanApiContext);
                            this.mApis.put("130910081", xy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xy1Var, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.removeStorage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 R = xy1Var.R(str);
                        if (R == null) {
                            return "";
                        }
                        return R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    xy1 xy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof xy1)) {
                            xy1Var = (xy1) obj;
                        } else {
                            xy1Var = new xy1(this.mSwanApiContext);
                            this.mApis.put("130910081", xy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xy1Var, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.removeStorageSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 T = xy1Var.T(str);
                        if (T == null) {
                            return "";
                        }
                        return T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    yy1 yy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof yy1)) {
                            yy1Var = (yy1) obj;
                        } else {
                            yy1Var = new yy1(this.mSwanApiContext);
                            this.mApis.put("-804054859", yy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(yy1Var, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.setGlobalStorage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 U = yy1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    yy1 yy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof yy1)) {
                            yy1Var = (yy1) obj;
                        } else {
                            yy1Var = new yy1(this.mSwanApiContext);
                            this.mApis.put("-804054859", yy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(yy1Var, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.setGlobalStorageSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 W = yy1Var.W(str);
                        if (W == null) {
                            return "";
                        }
                        return W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    xy1 xy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof xy1)) {
                            xy1Var = (xy1) obj;
                        } else {
                            xy1Var = new xy1(this.mSwanApiContext);
                            this.mApis.put("130910081", xy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xy1Var, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.setStorage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 U = xy1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    xy1 xy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof xy1)) {
                            xy1Var = (xy1) obj;
                        } else {
                            xy1Var = new xy1(this.mSwanApiContext);
                            this.mApis.put("130910081", xy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xy1Var, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.setStorageSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 W = xy1Var.W(str);
                        if (W == null) {
                            return "";
                        }
                        return W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    az1 az1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof az1)) {
                            az1Var = (az1) obj;
                        } else {
                            az1Var = new az1(this.mSwanApiContext);
                            this.mApis.put("823117982", az1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(az1Var, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Subscription.requestSubscribeFormId")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 E = az1Var.E(str);
                        if (E == null) {
                            return "";
                        }
                        return E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    bz1 bz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof bz1)) {
                            bz1Var = (bz1) obj;
                        } else {
                            bz1Var = new bz1(this.mSwanApiContext);
                            this.mApis.put("-947445811", bz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(bz1Var, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Subscription.subscribeService")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 F = bz1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    iz1 iz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof iz1)) {
                            iz1Var = (iz1) obj;
                        } else {
                            iz1Var = new iz1(this.mSwanApiContext);
                            this.mApis.put("1936205521", iz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(iz1Var, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.exitFullScreen")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = iz1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    hz1 hz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof hz1)) {
                            hz1Var = (hz1) obj;
                        } else {
                            hz1Var = new hz1(this.mSwanApiContext);
                            this.mApis.put("1694151270", hz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(hz1Var, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.getDeviceInfo")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = hz1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    jz1 jz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof jz1)) {
                            jz1Var = (jz1) obj;
                        } else {
                            jz1Var = new jz1(this.mSwanApiContext);
                            this.mApis.put("-1321681619", jz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(jz1Var, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.getDeviceProfile")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = jz1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    kz1 kz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof kz1)) {
                            kz1Var = (kz1) obj;
                        } else {
                            kz1Var = new kz1(this.mSwanApiContext);
                            this.mApis.put("-1569246082", kz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(kz1Var, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.makePhoneCall")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = kz1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    mz1 mz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof mz1)) {
                            mz1Var = (mz1) obj;
                        } else {
                            mz1Var = new mz1(this.mSwanApiContext);
                            this.mApis.put("1099851202", mz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(mz1Var, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.openSMSPanel")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = mz1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    lz1 lz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof lz1)) {
                            lz1Var = (lz1) obj;
                        } else {
                            lz1Var = new lz1(this.mSwanApiContext);
                            this.mApis.put("-1707203360", lz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(lz1Var, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.requestFullScreen")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 F = lz1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    fz1 fz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof fz1)) {
                            fz1Var = (fz1) obj;
                        } else {
                            fz1Var = new fz1(this.mSwanApiContext);
                            this.mApis.put("-518757484", fz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(fz1Var, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.setClipboardData")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = fz1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    py2 py2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof py2)) {
                            py2Var = (py2) obj;
                        } else {
                            py2Var = new py2(this.mSwanApiContext);
                            this.mApis.put("1161486049", py2Var);
                        }
                        Pair<Boolean, v02> a = x02.a(py2Var, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.setErrorPageType")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = py2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    pz1 pz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof pz1)) {
                            pz1Var = (pz1) obj;
                        } else {
                            pz1Var = new pz1(this.mSwanApiContext);
                            this.mApis.put("447234992", pz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(pz1Var, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.setMediaVolume")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 z = pz1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    dz1 dz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof dz1)) {
                            dz1Var = (dz1) obj;
                        } else {
                            dz1Var = new dz1(this.mSwanApiContext);
                            this.mApis.put("1372680763", dz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(dz1Var, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.startAccelerometer")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = dz1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    gz1 gz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof gz1)) {
                            gz1Var = (gz1) obj;
                        } else {
                            gz1Var = new gz1(this.mSwanApiContext);
                            this.mApis.put("1689255576", gz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(gz1Var, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.startCompass")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = gz1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    ez1 ez1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof ez1)) {
                            ez1Var = (ez1) obj;
                        } else {
                            ez1Var = new ez1(this.mSwanApiContext);
                            this.mApis.put("99997465", ez1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ez1Var, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.getBrightness")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = ez1Var.y();
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    fz1 fz1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof fz1)) {
                            fz1Var = (fz1) obj;
                        } else {
                            fz1Var = new fz1(this.mSwanApiContext);
                            this.mApis.put("-518757484", fz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(fz1Var, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.getClipboardData")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = fz1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    pz1 pz1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof pz1)) {
                            pz1Var = (pz1) obj;
                        } else {
                            pz1Var = new pz1(this.mSwanApiContext);
                            this.mApis.put("447234992", pz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(pz1Var, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.getMediaVolume")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = pz1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    dz1 dz1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof dz1)) {
                            dz1Var = (dz1) obj;
                        } else {
                            dz1Var = new dz1(this.mSwanApiContext);
                            this.mApis.put("1372680763", dz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(dz1Var, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.stopAccelerometer")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 B = dz1Var.B();
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    gz1 gz1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof gz1)) {
                            gz1Var = (gz1) obj;
                        } else {
                            gz1Var = new gz1(this.mSwanApiContext);
                            this.mApis.put("1689255576", gz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(gz1Var, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.stopCompass")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 z = gz1Var.z();
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    a02 a02Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof a02)) {
                            a02Var = (a02) obj;
                        } else {
                            a02Var = new a02(this.mSwanApiContext);
                            this.mApis.put("201194468", a02Var);
                        }
                        Pair<Boolean, v02> a = x02.a(a02Var, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.addToDesktop")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 B = a02Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    wz1 wz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof wz1)) {
                            wz1Var = (wz1) obj;
                        } else {
                            wz1Var = new wz1(this.mSwanApiContext);
                            this.mApis.put("-1412306947", wz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(wz1Var, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.calcMD5")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = wz1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    xz1 xz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof xz1)) {
                            xz1Var = (xz1) obj;
                        } else {
                            xz1Var = new xz1(this.mSwanApiContext);
                            this.mApis.put("1626415364", xz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xz1Var, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.checkAppInstalled")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = xz1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    zz1 zz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof zz1)) {
                            zz1Var = (zz1) obj;
                        } else {
                            zz1Var = new zz1(this.mSwanApiContext);
                            this.mApis.put("-836768778", zz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(zz1Var, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfo")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = zz1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    b02 b02Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof b02)) {
                            b02Var = (b02) obj;
                        } else {
                            b02Var = new b02(this.mSwanApiContext);
                            this.mApis.put("-810858308", b02Var);
                        }
                        Pair<Boolean, v02> a = x02.a(b02Var, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.getPerformanceLevel")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = b02Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    f02 f02Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof f02)) {
                            f02Var = (f02) obj;
                        } else {
                            f02Var = new f02(this.mSwanApiContext);
                            this.mApis.put("-1011537871", f02Var);
                        }
                        Pair<Boolean, v02> a = x02.a(f02Var, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.getSystemInfoAsync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 I = f02Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    c02 c02Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof c02)) {
                            c02Var = (c02) obj;
                        } else {
                            c02Var = new c02(this.mSwanApiContext);
                            this.mApis.put("-2097727681", c02Var);
                        }
                        Pair<Boolean, v02> a = x02.a(c02Var, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.handleException")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = c02Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    yz1 yz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof yz1)) {
                            yz1Var = (yz1) obj;
                        } else {
                            yz1Var = new yz1(this.mSwanApiContext);
                            this.mApis.put("2084449317", yz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(yz1Var, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.hasCloseHandler")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = yz1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    bd3 bd3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof bd3)) {
                            bd3Var = (bd3) obj;
                        } else {
                            bd3Var = new bd3(this.mSwanApiContext);
                            this.mApis.put("1031678042", bd3Var);
                        }
                        Pair<Boolean, v02> a = x02.a(bd3Var, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.hideCaptureScreenShareDialog")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = bd3Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    d02 d02Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof d02)) {
                            d02Var = (d02) obj;
                        } else {
                            d02Var = new d02(this.mSwanApiContext);
                            this.mApis.put("1751900130", d02Var);
                        }
                        Pair<Boolean, v02> a = x02.a(d02Var, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.logToFile")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = d02Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    cc3 cc3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof cc3)) {
                            cc3Var = (cc3) obj;
                        } else {
                            cc3Var = new cc3(this.mSwanApiContext);
                            this.mApis.put("1748196865", cc3Var);
                        }
                        Pair<Boolean, v02> a = x02.a(cc3Var, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.preloadPackage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = cc3Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    e02 e02Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof e02)) {
                            e02Var = (e02) obj;
                        } else {
                            e02Var = new e02(this.mSwanApiContext);
                            this.mApis.put("589529211", e02Var);
                        }
                        Pair<Boolean, v02> a = x02.a(e02Var, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.previewImage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 B = e02Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    h02 h02Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof h02)) {
                            h02Var = (h02) obj;
                        } else {
                            h02Var = new h02(this.mSwanApiContext);
                            this.mApis.put("-577481801", h02Var);
                        }
                        Pair<Boolean, v02> a = x02.a(h02Var, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.ubcFlowJar")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 I = h02Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    f02 f02Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof f02)) {
                            f02Var = (f02) obj;
                        } else {
                            f02Var = new f02(this.mSwanApiContext);
                            this.mApis.put("-1011537871", f02Var);
                        }
                        Pair<Boolean, v02> a = x02.a(f02Var, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfoSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 E = f02Var.E();
                        if (E == null) {
                            return "";
                        }
                        return E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    f02 f02Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof f02)) {
                            f02Var = (f02) obj;
                        } else {
                            f02Var = new f02(this.mSwanApiContext);
                            this.mApis.put("-1011537871", f02Var);
                        }
                        Pair<Boolean, v02> a = x02.a(f02Var, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.getSystemInfo")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 H = f02Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    f02 f02Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof f02)) {
                            f02Var = (f02) obj;
                        } else {
                            f02Var = new f02(this.mSwanApiContext);
                            this.mApis.put("-1011537871", f02Var);
                        }
                        Pair<Boolean, v02> a = x02.a(f02Var, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.getSystemInfoSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 J = f02Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    mj3 mj3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof mj3)) {
                            mj3Var = (mj3) obj;
                        } else {
                            mj3Var = new mj3(this.mSwanApiContext);
                            this.mApis.put("1879401452", mj3Var);
                        }
                        Pair<Boolean, v02> a = x02.a(mj3Var, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Wifi.connectWifi")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = mj3Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    mj3 mj3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof mj3)) {
                            mj3Var = (mj3) obj;
                        } else {
                            mj3Var = new mj3(this.mSwanApiContext);
                            this.mApis.put("1879401452", mj3Var);
                        }
                        Pair<Boolean, v02> a = x02.a(mj3Var, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Wifi.getConnectedWifi")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 B = mj3Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    mj3 mj3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof mj3)) {
                            mj3Var = (mj3) obj;
                        } else {
                            mj3Var = new mj3(this.mSwanApiContext);
                            this.mApis.put("1879401452", mj3Var);
                        }
                        Pair<Boolean, v02> a = x02.a(mj3Var, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Wifi.getWifiList")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 C = mj3Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    mj3 mj3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof mj3)) {
                            mj3Var = (mj3) obj;
                        } else {
                            mj3Var = new mj3(this.mSwanApiContext);
                            this.mApis.put("1879401452", mj3Var);
                        }
                        Pair<Boolean, v02> a = x02.a(mj3Var, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Wifi.startWifi")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 G = mj3Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    mj3 mj3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof mj3)) {
                            mj3Var = (mj3) obj;
                        } else {
                            mj3Var = new mj3(this.mSwanApiContext);
                            this.mApis.put("1879401452", mj3Var);
                        }
                        Pair<Boolean, v02> a = x02.a(mj3Var, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Wifi.stopWifi")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 H = mj3Var.H(str);
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

    public static Map<String, Object> getWebviewApiModules(final xw1 xw1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, xw1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    dx1 dx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof dx1)) {
                            dx1Var = (dx1) obj;
                        } else {
                            dx1Var = new dx1(this.mSwanApiContext);
                            this.mApis.put("1930258908", dx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(dx1Var, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Account.checkSession")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = dx1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    ex1 ex1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ex1)) {
                            ex1Var = (ex1) obj;
                        } else {
                            ex1Var = new ex1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ex1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ex1Var, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Account.getLoginCode")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 C = ex1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    fx1 fx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof fx1)) {
                            fx1Var = (fx1) obj;
                        } else {
                            fx1Var = new fx1(this.mSwanApiContext);
                            this.mApis.put("1754780133", fx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(fx1Var, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Account.getOpenId")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = fx1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    mw1 mw1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof mw1)) {
                            mw1Var = (mw1) obj;
                        } else {
                            mw1Var = new mw1(this.mSwanApiContext);
                            this.mApis.put("-343998465", mw1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(mw1Var, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Account.getUnionBDUSS")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = mw1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    ex1 ex1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ex1)) {
                            ex1Var = (ex1) obj;
                        } else {
                            ex1Var = new ex1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ex1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ex1Var, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Account.login")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 I = ex1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    cx1 cx1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof cx1)) {
                            cx1Var = (cx1) obj;
                        } else {
                            cx1Var = new cx1(this.mSwanApiContext);
                            this.mApis.put("-337742792", cx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(cx1Var, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Account.isBaiduAccountSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = cx1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    ex1 ex1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof ex1)) {
                            ex1Var = (ex1) obj;
                        } else {
                            ex1Var = new ex1(this.mSwanApiContext);
                            this.mApis.put("-1017914143", ex1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ex1Var, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Account.isLoginSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 H = ex1Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    gx1 gx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof gx1)) {
                            gx1Var = (gx1) obj;
                        } else {
                            gx1Var = new gx1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", gx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(gx1Var, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Basic.loadSubPackage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 F = gx1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    gx1 gx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof gx1)) {
                            gx1Var = (gx1) obj;
                        } else {
                            gx1Var = new gx1(this.mSwanApiContext);
                            this.mApis.put("-1249666566", gx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(gx1Var, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Basic.loadSubPackages")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 G = gx1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    np1 np1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof np1)) {
                            np1Var = (np1) obj;
                        } else {
                            np1Var = new np1(this.mSwanApiContext);
                            this.mApis.put("1460300387", np1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(np1Var, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Bookshelf.deleteBookshelf")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 K = np1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    np1 np1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof np1)) {
                            np1Var = (np1) obj;
                        } else {
                            np1Var = new np1(this.mSwanApiContext);
                            this.mApis.put("1460300387", np1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(np1Var, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Bookshelf.insertBookshelf")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 P = np1Var.P(str);
                        if (P == null) {
                            return "";
                        }
                        return P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    np1 np1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof np1)) {
                            np1Var = (np1) obj;
                        } else {
                            np1Var = new np1(this.mSwanApiContext);
                            this.mApis.put("1460300387", np1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(np1Var, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Bookshelf.navigateToBookshelf")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 U = np1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    np1 np1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof np1)) {
                            np1Var = (np1) obj;
                        } else {
                            np1Var = new np1(this.mSwanApiContext);
                            this.mApis.put("1460300387", np1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(np1Var, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Bookshelf.queryBookshelf")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 V = np1Var.V(str);
                        if (V == null) {
                            return "";
                        }
                        return V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    np1 np1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof np1)) {
                            np1Var = (np1) obj;
                        } else {
                            np1Var = new np1(this.mSwanApiContext);
                            this.mApis.put("1460300387", np1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(np1Var, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Bookshelf.updateBookshelfReadTime")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 X = np1Var.X(str);
                        if (X == null) {
                            return "";
                        }
                        return X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    ax1 ax1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof ax1)) {
                            ax1Var = (ax1) obj;
                        } else {
                            ax1Var = new ax1(this.mSwanApiContext);
                            this.mApis.put("-277316359", ax1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ax1Var, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Coupon.getPlatformCoupons")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = ax1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    ax1 ax1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof ax1)) {
                            ax1Var = (ax1) obj;
                        } else {
                            ax1Var = new ax1(this.mSwanApiContext);
                            this.mApis.put("-277316359", ax1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ax1Var, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Coupon.getUserCoupons")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 z = ax1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    ax1 ax1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof ax1)) {
                            ax1Var = (ax1) obj;
                        } else {
                            ax1Var = new ax1(this.mSwanApiContext);
                            this.mApis.put("-277316359", ax1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ax1Var, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Coupon.takeCoupons")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 C = ax1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    ix1 ix1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof ix1)) {
                            ix1Var = (ix1) obj;
                        } else {
                            ix1Var = new ix1(this.mSwanApiContext);
                            this.mApis.put("-1225406515", ix1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ix1Var, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Favorite.getFavorStatus")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = ix1Var.x(str);
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
                        Pair<Boolean, v02> a = x02.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Favorite.showFavoriteGuide")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 G = showFavoriteGuideApi.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    kx1 kx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof kx1)) {
                            kx1Var = (kx1) obj;
                        } else {
                            kx1Var = new kx1(this.mSwanApiContext);
                            this.mApis.put("-2057135077", kx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(kx1Var, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "File.shareFile")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = kx1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    zl2 zl2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof zl2)) {
                            zl2Var = (zl2) obj;
                        } else {
                            zl2Var = new zl2(this.mSwanApiContext);
                            this.mApis.put("2077414795", zl2Var);
                        }
                        Pair<Boolean, v02> a = x02.a(zl2Var, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = zl2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    zl2 zl2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof zl2)) {
                            zl2Var = (zl2) obj;
                        } else {
                            zl2Var = new zl2(this.mSwanApiContext);
                            this.mApis.put("2077414795", zl2Var);
                        }
                        Pair<Boolean, v02> a = x02.a(zl2Var, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "GameCenter.postGameCenterMessageSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = zl2Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String download(String str) {
                    lx1 lx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof lx1)) {
                            lx1Var = (lx1) obj;
                        } else {
                            lx1Var = new lx1(this.mSwanApiContext);
                            this.mApis.put("-170124576", lx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(lx1Var, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "HostDownloadManager.download")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = lx1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    lx1 lx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof lx1)) {
                            lx1Var = (lx1) obj;
                        } else {
                            lx1Var = new lx1(this.mSwanApiContext);
                            this.mApis.put("-170124576", lx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(lx1Var, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "HostDownloadManager.openFile")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 z = lx1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    lx1 lx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof lx1)) {
                            lx1Var = (lx1) obj;
                        } else {
                            lx1Var = new lx1(this.mSwanApiContext);
                            this.mApis.put("-170124576", lx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(lx1Var, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "HostDownloadManager.query")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 query = lx1Var.query(str);
                        if (query == null) {
                            return "";
                        }
                        return query.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    lx1 lx1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof lx1)) {
                            lx1Var = (lx1) obj;
                        } else {
                            lx1Var = new lx1(this.mSwanApiContext);
                            this.mApis.put("-170124576", lx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(lx1Var, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "HostDownloadManager.openDownloadCenter")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = lx1Var.y();
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naImage", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    ny2 ny2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof ny2)) {
                            ny2Var = (ny2) obj;
                        } else {
                            ny2Var = new ny2(this.mSwanApiContext);
                            this.mApis.put("1445003743", ny2Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ny2Var, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Image.callImageMenu")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = ny2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    ox1 ox1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof ox1)) {
                            ox1Var = (ox1) obj;
                        } else {
                            ox1Var = new ox1(this.mSwanApiContext);
                            this.mApis.put("-1252730367", ox1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ox1Var, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Image.compressImage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = ox1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    wx1 wx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof wx1)) {
                            wx1Var = (wx1) obj;
                        } else {
                            wx1Var = new wx1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", wx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(wx1Var, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.closeTabBar")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = wx1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    wx1 wx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof wx1)) {
                            wx1Var = (wx1) obj;
                        } else {
                            wx1Var = new wx1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", wx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(wx1Var, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.closeTabBarRedDot")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = wx1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    sx1 sx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof sx1)) {
                            sx1Var = (sx1) obj;
                        } else {
                            sx1Var = new sx1(this.mSwanApiContext);
                            this.mApis.put("-246386074", sx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(sx1Var, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.hideNavigationBarLoading")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = sx1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    ux1 ux1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ux1)) {
                            ux1Var = (ux1) obj;
                        } else {
                            ux1Var = new ux1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ux1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ux1Var, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.openMultiPicker")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 G = ux1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    ux1 ux1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ux1)) {
                            ux1Var = (ux1) obj;
                        } else {
                            ux1Var = new ux1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ux1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ux1Var, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.openPicker")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 H = ux1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    wx1 wx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof wx1)) {
                            wx1Var = (wx1) obj;
                        } else {
                            wx1Var = new wx1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", wx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(wx1Var, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.openTabBar")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 C = wx1Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    tx1 tx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof tx1)) {
                            tx1Var = (tx1) obj;
                        } else {
                            tx1Var = new tx1(this.mSwanApiContext);
                            this.mApis.put("-1750613704", tx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(tx1Var, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.pageScrollTo")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = tx1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    sx1 sx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof sx1)) {
                            sx1Var = (sx1) obj;
                        } else {
                            sx1Var = new sx1(this.mSwanApiContext);
                            this.mApis.put("-246386074", sx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(sx1Var, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarColor")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 z = sx1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    sx1 sx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof sx1)) {
                            sx1Var = (sx1) obj;
                        } else {
                            sx1Var = new sx1(this.mSwanApiContext);
                            this.mApis.put("-246386074", sx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(sx1Var, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.setNavigationBarTitle")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = sx1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    wx1 wx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof wx1)) {
                            wx1Var = (wx1) obj;
                        } else {
                            wx1Var = new wx1(this.mSwanApiContext);
                            this.mApis.put("-1871435471", wx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(wx1Var, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.setTabBarItem")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 D = wx1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    ux1 ux1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ux1)) {
                            ux1Var = (ux1) obj;
                        } else {
                            ux1Var = new ux1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ux1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ux1Var, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.showDatePickerView")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 L = ux1Var.L(str);
                        if (L == null) {
                            return "";
                        }
                        return L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    yx1 yx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof yx1)) {
                            yx1Var = (yx1) obj;
                        } else {
                            yx1Var = new yx1(this.mSwanApiContext);
                            this.mApis.put("1172469410", yx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(yx1Var, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.showHalfScreenWebview")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 K = yx1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    qx1 qx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof qx1)) {
                            qx1Var = (qx1) obj;
                        } else {
                            qx1Var = new qx1(this.mSwanApiContext);
                            this.mApis.put("5236036", qx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(qx1Var, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.showLoading")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = qx1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    rx1 rx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof rx1)) {
                            rx1Var = (rx1) obj;
                        } else {
                            rx1Var = new rx1(this.mSwanApiContext);
                            this.mApis.put("1913747800", rx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(rx1Var, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.showModal")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = rx1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    sx1 sx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof sx1)) {
                            sx1Var = (sx1) obj;
                        } else {
                            sx1Var = new sx1(this.mSwanApiContext);
                            this.mApis.put("-246386074", sx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(sx1Var, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.showNavigationBarLoading")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 B = sx1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    xx1 xx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof xx1)) {
                            xx1Var = (xx1) obj;
                        } else {
                            xx1Var = new xx1(this.mSwanApiContext);
                            this.mApis.put("1159492510", xx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xx1Var, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.showToast")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 Q = xx1Var.Q(str);
                        if (Q == null) {
                            return "";
                        }
                        return Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    vx1 vx1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof vx1)) {
                            vx1Var = (vx1) obj;
                        } else {
                            vx1Var = new vx1(this.mSwanApiContext);
                            this.mApis.put("1165118609", vx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(vx1Var, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.stopPullDownRefresh")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = vx1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    ux1 ux1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof ux1)) {
                            ux1Var = (ux1) obj;
                        } else {
                            ux1Var = new ux1(this.mSwanApiContext);
                            this.mApis.put("-108978463", ux1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ux1Var, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.updateMultiPicker")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 M = ux1Var.M(str);
                        if (M == null) {
                            return "";
                        }
                        return M.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    qx1 qx1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof qx1)) {
                            qx1Var = (qx1) obj;
                        } else {
                            qx1Var = new qx1(this.mSwanApiContext);
                            this.mApis.put("5236036", qx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(qx1Var, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.hideLoading")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = qx1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    xx1 xx1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof xx1)) {
                            xx1Var = (xx1) obj;
                        } else {
                            xx1Var = new xx1(this.mSwanApiContext);
                            this.mApis.put("1159492510", xx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xx1Var, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Interaction.hideToast")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 K = xx1Var.K();
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    zx1 zx1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof zx1)) {
                            zx1Var = (zx1) obj;
                        } else {
                            zx1Var = new zx1(this.mSwanApiContext);
                            this.mApis.put("-137346255", zx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(zx1Var, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Keyboard.startKeyboardHeightChange")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 C = zx1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    zx1 zx1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof zx1)) {
                            zx1Var = (zx1) obj;
                        } else {
                            zx1Var = new zx1(this.mSwanApiContext);
                            this.mApis.put("-137346255", zx1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(zx1Var, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Keyboard.stopKeyboardHeightChange")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 D = zx1Var.D();
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    ay1 ay1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof ay1)) {
                            ay1Var = (ay1) obj;
                        } else {
                            ay1Var = new ay1(this.mSwanApiContext);
                            this.mApis.put("-397373095", ay1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ay1Var, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "LocationService.getLocation")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = ay1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    ay1 ay1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof ay1)) {
                            ay1Var = (ay1) obj;
                        } else {
                            ay1Var = new ay1(this.mSwanApiContext);
                            this.mApis.put("-397373095", ay1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ay1Var, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "LocationService.startLocationUpdate")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = ay1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    ay1 ay1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof ay1)) {
                            ay1Var = (ay1) obj;
                        } else {
                            ay1Var = new ay1(this.mSwanApiContext);
                            this.mApis.put("-397373095", ay1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ay1Var, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "LocationService.stopLocationUpdate")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 B = ay1Var.B();
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    rz1 rz1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof rz1)) {
                            rz1Var = (rz1) obj;
                        } else {
                            rz1Var = new rz1(this.mSwanApiContext);
                            this.mApis.put("538070032", rz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(rz1Var, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = rz1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String callService(String str) {
                    dy1 dy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof dy1)) {
                            dy1Var = (dy1) obj;
                        } else {
                            dy1Var = new dy1(this.mSwanApiContext);
                            this.mApis.put("-1076509454", dy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(dy1Var, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Network.callService")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = dy1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    ky1 ky1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof ky1)) {
                            ky1Var = (ky1) obj;
                        } else {
                            ky1Var = new ky1(this.mSwanApiContext);
                            this.mApis.put("968563034", ky1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ky1Var, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Network.cancelRequest")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 D = ky1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    jy1 jy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof jy1)) {
                            jy1Var = (jy1) obj;
                        } else {
                            jy1Var = new jy1(this.mSwanApiContext);
                            this.mApis.put("453220699", jy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(jy1Var, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Network.networkStatusChange")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = jy1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    jy1 jy1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof jy1)) {
                            jy1Var = (jy1) obj;
                        } else {
                            jy1Var = new jy1(this.mSwanApiContext);
                            this.mApis.put("453220699", jy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(jy1Var, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Network.getNetworkType")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = jy1Var.x();
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
                    ky1 ky1Var;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        try {
                            u02.c().a("request");
                            Object obj = this.mApis.get("968563034");
                            if (obj != null && (obj instanceof ky1)) {
                                ky1Var = (ky1) obj;
                            } else {
                                ky1Var = new ky1(this.mSwanApiContext);
                                this.mApis.put("968563034", ky1Var);
                            }
                            Pair<Boolean, v02> a2 = x02.a(ky1Var, "swanAPI/request");
                            if (((Boolean) a2.first).booleanValue()) {
                                a = ((v02) a2.second).a();
                            } else if (db2.a(this.mSwanApiContext.f(), "Network.request")) {
                                a = new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            } else {
                                Pair<v02, JSONObject> u = zw1.u(str);
                                if (!((v02) u.first).isSuccess()) {
                                    a = ((v02) u.first).a();
                                } else {
                                    JSONObject jSONObject = (JSONObject) u.second;
                                    if (jSONObject == null) {
                                        a = v02.a.a();
                                    } else {
                                        w02 V = ky1Var.V(jSONObject);
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
            hashMap.put("_naPayment", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    t13 t13Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof t13)) {
                            t13Var = (t13) obj;
                        } else {
                            t13Var = new t13(this.mSwanApiContext);
                            this.mApis.put("-336396851", t13Var);
                        }
                        Pair<Boolean, v02> a = x02.a(t13Var, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Payment.chooseCoupon")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = t13Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    t13 t13Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof t13)) {
                            t13Var = (t13) obj;
                        } else {
                            t13Var = new t13(this.mSwanApiContext);
                            this.mApis.put("-336396851", t13Var);
                        }
                        Pair<Boolean, v02> a = x02.a(t13Var, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Payment.getPaymentInfo")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = t13Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    j13 j13Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof j13)) {
                            j13Var = (j13) obj;
                        } else {
                            j13Var = new j13(this.mSwanApiContext);
                            this.mApis.put("1854689529", j13Var);
                        }
                        Pair<Boolean, v02> a = x02.a(j13Var, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Payment.requestThirdPayment")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = j13Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    t13 t13Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof t13)) {
                            t13Var = (t13) obj;
                        } else {
                            t13Var = new t13(this.mSwanApiContext);
                            this.mApis.put("-336396851", t13Var);
                        }
                        Pair<Boolean, v02> a = x02.a(t13Var, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Payment.setPaymentInfo")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 z = t13Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    e43 e43Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof e43)) {
                            e43Var = (e43) obj;
                        } else {
                            e43Var = new e43(this.mSwanApiContext);
                            this.mApis.put("-254510461", e43Var);
                        }
                        Pair<Boolean, v02> a = x02.a(e43Var, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Plugin.invokePluginChooseAddress")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = e43Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    e43 e43Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof e43)) {
                            e43Var = (e43) obj;
                        } else {
                            e43Var = new e43(this.mSwanApiContext);
                            this.mApis.put("-254510461", e43Var);
                        }
                        Pair<Boolean, v02> a = x02.a(e43Var, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 z = e43Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    e43 e43Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof e43)) {
                            e43Var = (e43) obj;
                        } else {
                            e43Var = new e43(this.mSwanApiContext);
                            this.mApis.put("-254510461", e43Var);
                        }
                        Pair<Boolean, v02> a = x02.a(e43Var, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Plugin.invokePluginPayment")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = e43Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    xc2 xc2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof xc2)) {
                            xc2Var = (xc2) obj;
                        } else {
                            xc2Var = new xc2(this.mSwanApiContext);
                            this.mApis.put("-2068479848", xc2Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xc2Var, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Prefetch.prefetchResources")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = xc2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    pb2 pb2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof pb2)) {
                            pb2Var = (pb2) obj;
                        } else {
                            pb2Var = new pb2(this.mSwanApiContext);
                            this.mApis.put("423661539", pb2Var);
                        }
                        Pair<Boolean, v02> a = x02.a(pb2Var, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Preload.preloadStatus")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = pb2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    zk3 zk3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof zk3)) {
                            zk3Var = (zk3) obj;
                        } else {
                            zk3Var = new zk3(this.mSwanApiContext);
                            this.mApis.put("-1929343869", zk3Var);
                        }
                        Pair<Boolean, v02> a = x02.a(zk3Var, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "PrivateFile.uploadFileToBos")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 C = zk3Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    oy1 oy1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof oy1)) {
                            oy1Var = (oy1) obj;
                        } else {
                            oy1Var = new oy1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", oy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(oy1Var, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Router.hideModalPage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = oy1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    oy1 oy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof oy1)) {
                            oy1Var = (oy1) obj;
                        } else {
                            oy1Var = new oy1(this.mSwanApiContext);
                            this.mApis.put("-1495163604", oy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(oy1Var, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Router.navigateBack")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 B = oy1Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    py1 py1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof py1)) {
                            py1Var = (py1) obj;
                        } else {
                            py1Var = new py1(this.mSwanApiContext);
                            this.mApis.put("1968522584", py1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(py1Var, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Router.navigateTo")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 H = py1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    ry1 ry1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof ry1)) {
                            ry1Var = (ry1) obj;
                        } else {
                            ry1Var = new ry1(this.mSwanApiContext);
                            this.mApis.put("1317280190", ry1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ry1Var, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Router.reLaunch")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = ry1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    sy1 sy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof sy1)) {
                            sy1Var = (sy1) obj;
                        } else {
                            sy1Var = new sy1(this.mSwanApiContext);
                            this.mApis.put("-420075743", sy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(sy1Var, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Router.reLoadErrorPage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = sy1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    qy1 qy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof qy1)) {
                            qy1Var = (qy1) obj;
                        } else {
                            qy1Var = new qy1(this.mSwanApiContext);
                            this.mApis.put("1792515533", qy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(qy1Var, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Router.redirectTo")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 D = qy1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    py1 py1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof py1)) {
                            py1Var = (py1) obj;
                        } else {
                            py1Var = new py1(this.mSwanApiContext);
                            this.mApis.put("1968522584", py1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(py1Var, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Router.showModalPage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 J = py1Var.J(str);
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    vy1 vy1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof vy1)) {
                            vy1Var = (vy1) obj;
                        } else {
                            vy1Var = new vy1(this.mSwanApiContext);
                            this.mApis.put("-594895721", vy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(vy1Var, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Setting.getAppInfoSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 F = vy1Var.F();
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    vy1 vy1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof vy1)) {
                            vy1Var = (vy1) obj;
                        } else {
                            vy1Var = new vy1(this.mSwanApiContext);
                            this.mApis.put("-594895721", vy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(vy1Var, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Setting.getSlaveIdSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 H = vy1Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    uy1 uy1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof uy1)) {
                            uy1Var = (uy1) obj;
                        } else {
                            uy1Var = new uy1(this.mSwanApiContext);
                            this.mApis.put("450273045", uy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(uy1Var, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Setting.isAllowedAdOpenAppSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = uy1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    vy1 vy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof vy1)) {
                            vy1Var = (vy1) obj;
                        } else {
                            vy1Var = new vy1(this.mSwanApiContext);
                            this.mApis.put("-594895721", vy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(vy1Var, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Setting.getSetting")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 G = vy1Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    vy1 vy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof vy1)) {
                            vy1Var = (vy1) obj;
                        } else {
                            vy1Var = new vy1(this.mSwanApiContext);
                            this.mApis.put("-594895721", vy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(vy1Var, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Setting.getSwanId")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 I = vy1Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    vy1 vy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof vy1)) {
                            vy1Var = (vy1) obj;
                        } else {
                            vy1Var = new vy1(this.mSwanApiContext);
                            this.mApis.put("-594895721", vy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(vy1Var, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Setting.getUserInfo")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 J = vy1Var.J(str);
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    tf3 tf3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof tf3)) {
                            tf3Var = (tf3) obj;
                        } else {
                            tf3Var = new tf3(this.mSwanApiContext);
                            this.mApis.put("712777136", tf3Var);
                        }
                        Pair<Boolean, v02> a = x02.a(tf3Var, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = tf3Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    yy1 yy1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof yy1)) {
                            yy1Var = (yy1) obj;
                        } else {
                            yy1Var = new yy1(this.mSwanApiContext);
                            this.mApis.put("-804054859", yy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(yy1Var, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = yy1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    yy1 yy1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof yy1)) {
                            yy1Var = (yy1) obj;
                        } else {
                            yy1Var = new yy1(this.mSwanApiContext);
                            this.mApis.put("-804054859", yy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(yy1Var, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.clearGlobalStorageSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 C = yy1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    xy1 xy1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof xy1)) {
                            xy1Var = (xy1) obj;
                        } else {
                            xy1Var = new xy1(this.mSwanApiContext);
                            this.mApis.put("130910081", xy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xy1Var, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.clearStorage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = xy1Var.A();
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    xy1 xy1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof xy1)) {
                            xy1Var = (xy1) obj;
                        } else {
                            xy1Var = new xy1(this.mSwanApiContext);
                            this.mApis.put("130910081", xy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xy1Var, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.clearStorageSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 C = xy1Var.C();
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    yy1 yy1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof yy1)) {
                            yy1Var = (yy1) obj;
                        } else {
                            yy1Var = new yy1(this.mSwanApiContext);
                            this.mApis.put("-804054859", yy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(yy1Var, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfo")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 G = yy1Var.G();
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    yy1 yy1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof yy1)) {
                            yy1Var = (yy1) obj;
                        } else {
                            yy1Var = new yy1(this.mSwanApiContext);
                            this.mApis.put("-804054859", yy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(yy1Var, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageInfoSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 J = yy1Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    xy1 xy1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof xy1)) {
                            xy1Var = (xy1) obj;
                        } else {
                            xy1Var = new xy1(this.mSwanApiContext);
                            this.mApis.put("130910081", xy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xy1Var, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.getStorageInfo")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 G = xy1Var.G();
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    xy1 xy1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof xy1)) {
                            xy1Var = (xy1) obj;
                        } else {
                            xy1Var = new xy1(this.mSwanApiContext);
                            this.mApis.put("130910081", xy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xy1Var, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.getStorageInfoSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 J = xy1Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    yy1 yy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof yy1)) {
                            yy1Var = (yy1) obj;
                        } else {
                            yy1Var = new yy1(this.mSwanApiContext);
                            this.mApis.put("-804054859", yy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(yy1Var, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 D = yy1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    yy1 yy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof yy1)) {
                            yy1Var = (yy1) obj;
                        } else {
                            yy1Var = new yy1(this.mSwanApiContext);
                            this.mApis.put("-804054859", yy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(yy1Var, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.getGlobalStorageSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 K = yy1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    xy1 xy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof xy1)) {
                            xy1Var = (xy1) obj;
                        } else {
                            xy1Var = new xy1(this.mSwanApiContext);
                            this.mApis.put("130910081", xy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xy1Var, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.getStorage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 D = xy1Var.D(str);
                        if (D == null) {
                            return "";
                        }
                        return D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    xy1 xy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof xy1)) {
                            xy1Var = (xy1) obj;
                        } else {
                            xy1Var = new xy1(this.mSwanApiContext);
                            this.mApis.put("130910081", xy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xy1Var, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.getStorageInfoAsync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 H = xy1Var.H(str);
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    xy1 xy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof xy1)) {
                            xy1Var = (xy1) obj;
                        } else {
                            xy1Var = new xy1(this.mSwanApiContext);
                            this.mApis.put("130910081", xy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xy1Var, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.getStorageSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 K = xy1Var.K(str);
                        if (K == null) {
                            return "";
                        }
                        return K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    yy1 yy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof yy1)) {
                            yy1Var = (yy1) obj;
                        } else {
                            yy1Var = new yy1(this.mSwanApiContext);
                            this.mApis.put("-804054859", yy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(yy1Var, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 R = yy1Var.R(str);
                        if (R == null) {
                            return "";
                        }
                        return R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    yy1 yy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof yy1)) {
                            yy1Var = (yy1) obj;
                        } else {
                            yy1Var = new yy1(this.mSwanApiContext);
                            this.mApis.put("-804054859", yy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(yy1Var, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.removeGlobalStorageSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 T = yy1Var.T(str);
                        if (T == null) {
                            return "";
                        }
                        return T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    xy1 xy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof xy1)) {
                            xy1Var = (xy1) obj;
                        } else {
                            xy1Var = new xy1(this.mSwanApiContext);
                            this.mApis.put("130910081", xy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xy1Var, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.removeStorage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 R = xy1Var.R(str);
                        if (R == null) {
                            return "";
                        }
                        return R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    xy1 xy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof xy1)) {
                            xy1Var = (xy1) obj;
                        } else {
                            xy1Var = new xy1(this.mSwanApiContext);
                            this.mApis.put("130910081", xy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xy1Var, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.removeStorageSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 T = xy1Var.T(str);
                        if (T == null) {
                            return "";
                        }
                        return T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    yy1 yy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof yy1)) {
                            yy1Var = (yy1) obj;
                        } else {
                            yy1Var = new yy1(this.mSwanApiContext);
                            this.mApis.put("-804054859", yy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(yy1Var, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.setGlobalStorage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 U = yy1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    yy1 yy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof yy1)) {
                            yy1Var = (yy1) obj;
                        } else {
                            yy1Var = new yy1(this.mSwanApiContext);
                            this.mApis.put("-804054859", yy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(yy1Var, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.setGlobalStorageSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 W = yy1Var.W(str);
                        if (W == null) {
                            return "";
                        }
                        return W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    xy1 xy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof xy1)) {
                            xy1Var = (xy1) obj;
                        } else {
                            xy1Var = new xy1(this.mSwanApiContext);
                            this.mApis.put("130910081", xy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xy1Var, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.setStorage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 U = xy1Var.U(str);
                        if (U == null) {
                            return "";
                        }
                        return U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    xy1 xy1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof xy1)) {
                            xy1Var = (xy1) obj;
                        } else {
                            xy1Var = new xy1(this.mSwanApiContext);
                            this.mApis.put("130910081", xy1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xy1Var, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Storage.setStorageSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 W = xy1Var.W(str);
                        if (W == null) {
                            return "";
                        }
                        return W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    az1 az1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof az1)) {
                            az1Var = (az1) obj;
                        } else {
                            az1Var = new az1(this.mSwanApiContext);
                            this.mApis.put("823117982", az1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(az1Var, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Subscription.requestSubscribeFormId")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 E = az1Var.E(str);
                        if (E == null) {
                            return "";
                        }
                        return E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    bz1 bz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof bz1)) {
                            bz1Var = (bz1) obj;
                        } else {
                            bz1Var = new bz1(this.mSwanApiContext);
                            this.mApis.put("-947445811", bz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(bz1Var, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Subscription.subscribeService")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 F = bz1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    iz1 iz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof iz1)) {
                            iz1Var = (iz1) obj;
                        } else {
                            iz1Var = new iz1(this.mSwanApiContext);
                            this.mApis.put("1936205521", iz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(iz1Var, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.exitFullScreen")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = iz1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    hz1 hz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof hz1)) {
                            hz1Var = (hz1) obj;
                        } else {
                            hz1Var = new hz1(this.mSwanApiContext);
                            this.mApis.put("1694151270", hz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(hz1Var, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.getDeviceInfo")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = hz1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    jz1 jz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof jz1)) {
                            jz1Var = (jz1) obj;
                        } else {
                            jz1Var = new jz1(this.mSwanApiContext);
                            this.mApis.put("-1321681619", jz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(jz1Var, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.getDeviceProfile")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = jz1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    kz1 kz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof kz1)) {
                            kz1Var = (kz1) obj;
                        } else {
                            kz1Var = new kz1(this.mSwanApiContext);
                            this.mApis.put("-1569246082", kz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(kz1Var, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.makePhoneCall")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = kz1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    mz1 mz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof mz1)) {
                            mz1Var = (mz1) obj;
                        } else {
                            mz1Var = new mz1(this.mSwanApiContext);
                            this.mApis.put("1099851202", mz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(mz1Var, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.openSMSPanel")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = mz1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    lz1 lz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof lz1)) {
                            lz1Var = (lz1) obj;
                        } else {
                            lz1Var = new lz1(this.mSwanApiContext);
                            this.mApis.put("-1707203360", lz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(lz1Var, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.requestFullScreen")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 F = lz1Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    fz1 fz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof fz1)) {
                            fz1Var = (fz1) obj;
                        } else {
                            fz1Var = new fz1(this.mSwanApiContext);
                            this.mApis.put("-518757484", fz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(fz1Var, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.setClipboardData")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = fz1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    py2 py2Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof py2)) {
                            py2Var = (py2) obj;
                        } else {
                            py2Var = new py2(this.mSwanApiContext);
                            this.mApis.put("1161486049", py2Var);
                        }
                        Pair<Boolean, v02> a = x02.a(py2Var, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.setErrorPageType")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = py2Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    pz1 pz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof pz1)) {
                            pz1Var = (pz1) obj;
                        } else {
                            pz1Var = new pz1(this.mSwanApiContext);
                            this.mApis.put("447234992", pz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(pz1Var, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.setMediaVolume")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 z = pz1Var.z(str);
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    dz1 dz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof dz1)) {
                            dz1Var = (dz1) obj;
                        } else {
                            dz1Var = new dz1(this.mSwanApiContext);
                            this.mApis.put("1372680763", dz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(dz1Var, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.startAccelerometer")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = dz1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    gz1 gz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof gz1)) {
                            gz1Var = (gz1) obj;
                        } else {
                            gz1Var = new gz1(this.mSwanApiContext);
                            this.mApis.put("1689255576", gz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(gz1Var, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.startCompass")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = gz1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    ez1 ez1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof ez1)) {
                            ez1Var = (ez1) obj;
                        } else {
                            ez1Var = new ez1(this.mSwanApiContext);
                            this.mApis.put("99997465", ez1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(ez1Var, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.getBrightness")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = ez1Var.y();
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    fz1 fz1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof fz1)) {
                            fz1Var = (fz1) obj;
                        } else {
                            fz1Var = new fz1(this.mSwanApiContext);
                            this.mApis.put("-518757484", fz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(fz1Var, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.getClipboardData")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = fz1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    pz1 pz1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof pz1)) {
                            pz1Var = (pz1) obj;
                        } else {
                            pz1Var = new pz1(this.mSwanApiContext);
                            this.mApis.put("447234992", pz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(pz1Var, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.getMediaVolume")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = pz1Var.x();
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    dz1 dz1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof dz1)) {
                            dz1Var = (dz1) obj;
                        } else {
                            dz1Var = new dz1(this.mSwanApiContext);
                            this.mApis.put("1372680763", dz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(dz1Var, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.stopAccelerometer")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 B = dz1Var.B();
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    gz1 gz1Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof gz1)) {
                            gz1Var = (gz1) obj;
                        } else {
                            gz1Var = new gz1(this.mSwanApiContext);
                            this.mApis.put("1689255576", gz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(gz1Var, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "System.stopCompass")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 z = gz1Var.z();
                        if (z == null) {
                            return "";
                        }
                        return z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    a02 a02Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof a02)) {
                            a02Var = (a02) obj;
                        } else {
                            a02Var = new a02(this.mSwanApiContext);
                            this.mApis.put("201194468", a02Var);
                        }
                        Pair<Boolean, v02> a = x02.a(a02Var, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.addToDesktop")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 B = a02Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    wz1 wz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof wz1)) {
                            wz1Var = (wz1) obj;
                        } else {
                            wz1Var = new wz1(this.mSwanApiContext);
                            this.mApis.put("-1412306947", wz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(wz1Var, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.calcMD5")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = wz1Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    xz1 xz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof xz1)) {
                            xz1Var = (xz1) obj;
                        } else {
                            xz1Var = new xz1(this.mSwanApiContext);
                            this.mApis.put("1626415364", xz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(xz1Var, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.checkAppInstalled")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = xz1Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    zz1 zz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof zz1)) {
                            zz1Var = (zz1) obj;
                        } else {
                            zz1Var = new zz1(this.mSwanApiContext);
                            this.mApis.put("-836768778", zz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(zz1Var, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfo")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = zz1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    b02 b02Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof b02)) {
                            b02Var = (b02) obj;
                        } else {
                            b02Var = new b02(this.mSwanApiContext);
                            this.mApis.put("-810858308", b02Var);
                        }
                        Pair<Boolean, v02> a = x02.a(b02Var, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.getPerformanceLevel")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = b02Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    f02 f02Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof f02)) {
                            f02Var = (f02) obj;
                        } else {
                            f02Var = new f02(this.mSwanApiContext);
                            this.mApis.put("-1011537871", f02Var);
                        }
                        Pair<Boolean, v02> a = x02.a(f02Var, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.getSystemInfoAsync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 I = f02Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    c02 c02Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof c02)) {
                            c02Var = (c02) obj;
                        } else {
                            c02Var = new c02(this.mSwanApiContext);
                            this.mApis.put("-2097727681", c02Var);
                        }
                        Pair<Boolean, v02> a = x02.a(c02Var, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.handleException")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = c02Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    yz1 yz1Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof yz1)) {
                            yz1Var = (yz1) obj;
                        } else {
                            yz1Var = new yz1(this.mSwanApiContext);
                            this.mApis.put("2084449317", yz1Var);
                        }
                        Pair<Boolean, v02> a = x02.a(yz1Var, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.hasCloseHandler")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = yz1Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    bd3 bd3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof bd3)) {
                            bd3Var = (bd3) obj;
                        } else {
                            bd3Var = new bd3(this.mSwanApiContext);
                            this.mApis.put("1031678042", bd3Var);
                        }
                        Pair<Boolean, v02> a = x02.a(bd3Var, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.hideCaptureScreenShareDialog")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 x = bd3Var.x(str);
                        if (x == null) {
                            return "";
                        }
                        return x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    d02 d02Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof d02)) {
                            d02Var = (d02) obj;
                        } else {
                            d02Var = new d02(this.mSwanApiContext);
                            this.mApis.put("1751900130", d02Var);
                        }
                        Pair<Boolean, v02> a = x02.a(d02Var, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.logToFile")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = d02Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    cc3 cc3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof cc3)) {
                            cc3Var = (cc3) obj;
                        } else {
                            cc3Var = new cc3(this.mSwanApiContext);
                            this.mApis.put("1748196865", cc3Var);
                        }
                        Pair<Boolean, v02> a = x02.a(cc3Var, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.preloadPackage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = cc3Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    e02 e02Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof e02)) {
                            e02Var = (e02) obj;
                        } else {
                            e02Var = new e02(this.mSwanApiContext);
                            this.mApis.put("589529211", e02Var);
                        }
                        Pair<Boolean, v02> a = x02.a(e02Var, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.previewImage")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 B = e02Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    h02 h02Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof h02)) {
                            h02Var = (h02) obj;
                        } else {
                            h02Var = new h02(this.mSwanApiContext);
                            this.mApis.put("-577481801", h02Var);
                        }
                        Pair<Boolean, v02> a = x02.a(h02Var, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.ubcFlowJar")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 I = h02Var.I(str);
                        if (I == null) {
                            return "";
                        }
                        return I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    f02 f02Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof f02)) {
                            f02Var = (f02) obj;
                        } else {
                            f02Var = new f02(this.mSwanApiContext);
                            this.mApis.put("-1011537871", f02Var);
                        }
                        Pair<Boolean, v02> a = x02.a(f02Var, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.getCommonSysInfoSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 E = f02Var.E();
                        if (E == null) {
                            return "";
                        }
                        return E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    f02 f02Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof f02)) {
                            f02Var = (f02) obj;
                        } else {
                            f02Var = new f02(this.mSwanApiContext);
                            this.mApis.put("-1011537871", f02Var);
                        }
                        Pair<Boolean, v02> a = x02.a(f02Var, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.getSystemInfo")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 H = f02Var.H();
                        if (H == null) {
                            return "";
                        }
                        return H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    f02 f02Var;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof f02)) {
                            f02Var = (f02) obj;
                        } else {
                            f02Var = new f02(this.mSwanApiContext);
                            this.mApis.put("-1011537871", f02Var);
                        }
                        Pair<Boolean, v02> a = x02.a(f02Var, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Utils.getSystemInfoSync")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 J = f02Var.J();
                        if (J == null) {
                            return "";
                        }
                        return J.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public xw1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {xw1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = xw1Var;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    mj3 mj3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof mj3)) {
                            mj3Var = (mj3) obj;
                        } else {
                            mj3Var = new mj3(this.mSwanApiContext);
                            this.mApis.put("1879401452", mj3Var);
                        }
                        Pair<Boolean, v02> a = x02.a(mj3Var, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Wifi.connectWifi")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 A = mj3Var.A(str);
                        if (A == null) {
                            return "";
                        }
                        return A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    mj3 mj3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof mj3)) {
                            mj3Var = (mj3) obj;
                        } else {
                            mj3Var = new mj3(this.mSwanApiContext);
                            this.mApis.put("1879401452", mj3Var);
                        }
                        Pair<Boolean, v02> a = x02.a(mj3Var, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Wifi.getConnectedWifi")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 B = mj3Var.B(str);
                        if (B == null) {
                            return "";
                        }
                        return B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    mj3 mj3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof mj3)) {
                            mj3Var = (mj3) obj;
                        } else {
                            mj3Var = new mj3(this.mSwanApiContext);
                            this.mApis.put("1879401452", mj3Var);
                        }
                        Pair<Boolean, v02> a = x02.a(mj3Var, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Wifi.getWifiList")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 C = mj3Var.C(str);
                        if (C == null) {
                            return "";
                        }
                        return C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    mj3 mj3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof mj3)) {
                            mj3Var = (mj3) obj;
                        } else {
                            mj3Var = new mj3(this.mSwanApiContext);
                            this.mApis.put("1879401452", mj3Var);
                        }
                        Pair<Boolean, v02> a = x02.a(mj3Var, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Wifi.startWifi")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 G = mj3Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    mj3 mj3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof mj3)) {
                            mj3Var = (mj3) obj;
                        } else {
                            mj3Var = new mj3(this.mSwanApiContext);
                            this.mApis.put("1879401452", mj3Var);
                        }
                        Pair<Boolean, v02> a = x02.a(mj3Var, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "Wifi.stopWifi")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 H = mj3Var.H(str);
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
