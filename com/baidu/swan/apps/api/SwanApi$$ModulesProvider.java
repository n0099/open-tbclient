package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import c.a.r0.a.h0.l.g.f;
import c.a.r0.a.n2.r;
import c.a.r0.a.u.c.b;
import c.a.r0.a.u.e.a.c;
import c.a.r0.a.u.e.a.d;
import c.a.r0.a.u.e.a.e;
import c.a.r0.a.u.e.f.g;
import c.a.r0.a.u.e.f.h;
import c.a.r0.a.u.e.f.i;
import c.a.r0.a.u.e.f.j;
import c.a.r0.a.u.e.n.k;
import c.a.r0.a.u.e.n.n;
import c.a.r0.a.u.e.p.m;
import c.a.r0.a.u.h.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.module.favorite.ShowFavoriteGuideApi;
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
/* loaded from: classes11.dex */
public class SwanApi$$ModulesProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SwanApi$$ModulesProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Map<String, Object> getV8ApiModules(final b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof c)) {
                            cVar = (c) obj;
                        } else {
                            cVar = new c(this.mSwanApiContext);
                            this.mApis.put("1930258908", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Account.checkSession")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = cVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    d dVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof d)) {
                            dVar = (d) obj;
                        } else {
                            dVar = new d(this.mSwanApiContext);
                            this.mApis.put("-1017914143", dVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(dVar, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Account.getLoginCode")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b C = dVar.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    e eVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof e)) {
                            eVar = (e) obj;
                        } else {
                            eVar = new e(this.mSwanApiContext);
                            this.mApis.put("1754780133", eVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(eVar, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Account.getOpenId")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = eVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    c.a.r0.a.s.a.i.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof c.a.r0.a.s.a.i.a)) {
                            aVar = (c.a.r0.a.s.a.i.a) obj;
                        } else {
                            aVar = new c.a.r0.a.s.a.i.a(this.mSwanApiContext);
                            this.mApis.put("-343998465", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Account.getUnionBDUSS")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = aVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    c.a.r0.a.u.e.a.b bVar2;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.a.b)) {
                            bVar2 = (c.a.r0.a.u.e.a.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.a.b(this.mSwanApiContext);
                            this.mApis.put("-337742792", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Account.isBaiduAccountSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = bVar2.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    d dVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof d)) {
                            dVar = (d) obj;
                        } else {
                            dVar = new d(this.mSwanApiContext);
                            this.mApis.put("-1017914143", dVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(dVar, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Account.isLoginSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b H = dVar.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    d dVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof d)) {
                            dVar = (d) obj;
                        } else {
                            dVar = new d(this.mSwanApiContext);
                            this.mApis.put("-1017914143", dVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(dVar, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Account.login")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b I = dVar.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    c.a.r0.a.u.e.b.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.b.a)) {
                            aVar = (c.a.r0.a.u.e.b.a) obj;
                        } else {
                            aVar = new c.a.r0.a.u.e.b.a(this.mSwanApiContext);
                            this.mApis.put("-1249666566", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Basic.loadSubPackage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b F = aVar.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    c.a.r0.a.u.e.b.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.b.a)) {
                            aVar = (c.a.r0.a.u.e.b.a) obj;
                        } else {
                            aVar = new c.a.r0.a.u.e.b.a(this.mSwanApiContext);
                            this.mApis.put("-1249666566", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Basic.loadSubPackages")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b G = aVar.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    c.a.r0.a.n.b.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof c.a.r0.a.n.b.a)) {
                            aVar = (c.a.r0.a.n.b.a) obj;
                        } else {
                            aVar = new c.a.r0.a.n.b.a(this.mSwanApiContext);
                            this.mApis.put("1460300387", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Bookshelf.deleteBookshelf")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b K = aVar.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    c.a.r0.a.n.b.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof c.a.r0.a.n.b.a)) {
                            aVar = (c.a.r0.a.n.b.a) obj;
                        } else {
                            aVar = new c.a.r0.a.n.b.a(this.mSwanApiContext);
                            this.mApis.put("1460300387", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Bookshelf.insertBookshelf")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b P = aVar.P(str);
                        return P == null ? "" : P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    c.a.r0.a.n.b.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof c.a.r0.a.n.b.a)) {
                            aVar = (c.a.r0.a.n.b.a) obj;
                        } else {
                            aVar = new c.a.r0.a.n.b.a(this.mSwanApiContext);
                            this.mApis.put("1460300387", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Bookshelf.navigateToBookshelf")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b U = aVar.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    c.a.r0.a.n.b.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof c.a.r0.a.n.b.a)) {
                            aVar = (c.a.r0.a.n.b.a) obj;
                        } else {
                            aVar = new c.a.r0.a.n.b.a(this.mSwanApiContext);
                            this.mApis.put("1460300387", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Bookshelf.queryBookshelf")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b V = aVar.V(str);
                        return V == null ? "" : V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    c.a.r0.a.n.b.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof c.a.r0.a.n.b.a)) {
                            aVar = (c.a.r0.a.n.b.a) obj;
                        } else {
                            aVar = new c.a.r0.a.n.b.a(this.mSwanApiContext);
                            this.mApis.put("1460300387", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Bookshelf.updateBookshelfReadTime")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b X = aVar.X(str);
                        return X == null ? "" : X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    c.a.r0.a.u.d.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof c.a.r0.a.u.d.a)) {
                            aVar = (c.a.r0.a.u.d.a) obj;
                        } else {
                            aVar = new c.a.r0.a.u.d.a(this.mSwanApiContext);
                            this.mApis.put("-277316359", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Coupon.getPlatformCoupons")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = aVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    c.a.r0.a.u.d.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof c.a.r0.a.u.d.a)) {
                            aVar = (c.a.r0.a.u.d.a) obj;
                        } else {
                            aVar = new c.a.r0.a.u.d.a(this.mSwanApiContext);
                            this.mApis.put("-277316359", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Coupon.getUserCoupons")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b z = aVar.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    c.a.r0.a.u.d.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof c.a.r0.a.u.d.a)) {
                            aVar = (c.a.r0.a.u.d.a) obj;
                        } else {
                            aVar = new c.a.r0.a.u.d.a(this.mSwanApiContext);
                            this.mApis.put("-277316359", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Coupon.takeCoupons")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b C = aVar.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    c.a.r0.a.u.e.c.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.c.b)) {
                            bVar2 = (c.a.r0.a.u.e.c.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.c.b(this.mSwanApiContext);
                            this.mApis.put("-1225406515", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Favorite.getFavorStatus")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = bVar2.x(str);
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
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Favorite.showFavoriteGuide")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b G = showFavoriteGuideApi.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$FileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    c.a.r0.a.u.e.d.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.d.a)) {
                            aVar = (c.a.r0.a.u.e.d.a) obj;
                        } else {
                            aVar = new c.a.r0.a.u.e.d.a(this.mSwanApiContext);
                            this.mApis.put("-2057135077", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "File.shareFile")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = aVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    c.a.r0.a.u0.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof c.a.r0.a.u0.a)) {
                            aVar = (c.a.r0.a.u0.a) obj;
                        } else {
                            aVar = new c.a.r0.a.u0.a(this.mSwanApiContext);
                            this.mApis.put("2077414795", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "GameCenter.postGameCenterMessage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = aVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    c.a.r0.a.u0.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof c.a.r0.a.u0.a)) {
                            aVar = (c.a.r0.a.u0.a) obj;
                        } else {
                            aVar = new c.a.r0.a.u0.a(this.mSwanApiContext);
                            this.mApis.put("2077414795", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "GameCenter.postGameCenterMessageSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = aVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String download(String str) {
                    c.a.r0.a.u.e.d.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.d.b)) {
                            bVar2 = (c.a.r0.a.u.e.d.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.d.b(this.mSwanApiContext);
                            this.mApis.put("-170124576", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "HostDownloadManager.download")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = bVar2.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    c.a.r0.a.u.e.d.b bVar2;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.d.b)) {
                            bVar2 = (c.a.r0.a.u.e.d.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.d.b(this.mSwanApiContext);
                            this.mApis.put("-170124576", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "HostDownloadManager.openDownloadCenter")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = bVar2.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    c.a.r0.a.u.e.d.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.d.b)) {
                            bVar2 = (c.a.r0.a.u.e.d.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.d.b(this.mSwanApiContext);
                            this.mApis.put("-170124576", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "HostDownloadManager.openFile")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b z = bVar2.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    c.a.r0.a.u.e.d.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.d.b)) {
                            bVar2 = (c.a.r0.a.u.e.d.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.d.b(this.mSwanApiContext);
                            this.mApis.put("-170124576", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "HostDownloadManager.query")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b query = bVar2.query(str);
                        return query == null ? "" : query.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naImage", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    c.a.r0.a.k1.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof c.a.r0.a.k1.b)) {
                            bVar2 = (c.a.r0.a.k1.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.k1.b(this.mSwanApiContext);
                            this.mApis.put("1445003743", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Image.callImageMenu")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = bVar2.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    c.a.r0.a.u.e.e.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.e.b)) {
                            bVar2 = (c.a.r0.a.u.e.e.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.e.b(this.mSwanApiContext);
                            this.mApis.put("-1252730367", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Image.compressImage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = bVar2.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    h hVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof h)) {
                            hVar = (h) obj;
                        } else {
                            hVar = new h(this.mSwanApiContext);
                            this.mApis.put("-1871435471", hVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(hVar, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.closeTabBar")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = hVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    h hVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof h)) {
                            hVar = (h) obj;
                        } else {
                            hVar = new h(this.mSwanApiContext);
                            this.mApis.put("-1871435471", hVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(hVar, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.closeTabBarRedDot")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = hVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    c.a.r0.a.u.e.f.b bVar2;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.f.b)) {
                            bVar2 = (c.a.r0.a.u.e.f.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.f.b(this.mSwanApiContext);
                            this.mApis.put("5236036", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.hideLoading")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = bVar2.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    c.a.r0.a.u.e.f.d dVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.f.d)) {
                            dVar = (c.a.r0.a.u.e.f.d) obj;
                        } else {
                            dVar = new c.a.r0.a.u.e.f.d(this.mSwanApiContext);
                            this.mApis.put("-246386074", dVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(dVar, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.hideNavigationBarLoading")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = dVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    i iVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof i)) {
                            iVar = (i) obj;
                        } else {
                            iVar = new i(this.mSwanApiContext);
                            this.mApis.put("1159492510", iVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(iVar, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.hideToast")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b K = iVar.K();
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    c.a.r0.a.u.e.f.f fVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.f.f)) {
                            fVar = (c.a.r0.a.u.e.f.f) obj;
                        } else {
                            fVar = new c.a.r0.a.u.e.f.f(this.mSwanApiContext);
                            this.mApis.put("-108978463", fVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(fVar, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.openMultiPicker")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b G = fVar.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    c.a.r0.a.u.e.f.f fVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.f.f)) {
                            fVar = (c.a.r0.a.u.e.f.f) obj;
                        } else {
                            fVar = new c.a.r0.a.u.e.f.f(this.mSwanApiContext);
                            this.mApis.put("-108978463", fVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(fVar, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.openPicker")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b H = fVar.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    h hVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof h)) {
                            hVar = (h) obj;
                        } else {
                            hVar = new h(this.mSwanApiContext);
                            this.mApis.put("-1871435471", hVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(hVar, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.openTabBar")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b C = hVar.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    c.a.r0.a.u.e.f.e eVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.f.e)) {
                            eVar = (c.a.r0.a.u.e.f.e) obj;
                        } else {
                            eVar = new c.a.r0.a.u.e.f.e(this.mSwanApiContext);
                            this.mApis.put("-1750613704", eVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(eVar, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.pageScrollTo")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = eVar.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    c.a.r0.a.u.e.f.d dVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.f.d)) {
                            dVar = (c.a.r0.a.u.e.f.d) obj;
                        } else {
                            dVar = new c.a.r0.a.u.e.f.d(this.mSwanApiContext);
                            this.mApis.put("-246386074", dVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(dVar, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.setNavigationBarColor")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b z = dVar.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    c.a.r0.a.u.e.f.d dVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.f.d)) {
                            dVar = (c.a.r0.a.u.e.f.d) obj;
                        } else {
                            dVar = new c.a.r0.a.u.e.f.d(this.mSwanApiContext);
                            this.mApis.put("-246386074", dVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(dVar, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.setNavigationBarTitle")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = dVar.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    h hVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof h)) {
                            hVar = (h) obj;
                        } else {
                            hVar = new h(this.mSwanApiContext);
                            this.mApis.put("-1871435471", hVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(hVar, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.setTabBarItem")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b D = hVar.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    c.a.r0.a.u.e.f.f fVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.f.f)) {
                            fVar = (c.a.r0.a.u.e.f.f) obj;
                        } else {
                            fVar = new c.a.r0.a.u.e.f.f(this.mSwanApiContext);
                            this.mApis.put("-108978463", fVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(fVar, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.showDatePickerView")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b L = fVar.L(str);
                        return L == null ? "" : L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    j jVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof j)) {
                            jVar = (j) obj;
                        } else {
                            jVar = new j(this.mSwanApiContext);
                            this.mApis.put("1172469410", jVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(jVar, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.showHalfScreenWebview")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b K = jVar.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    c.a.r0.a.u.e.f.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.f.b)) {
                            bVar2 = (c.a.r0.a.u.e.f.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.f.b(this.mSwanApiContext);
                            this.mApis.put("5236036", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.showLoading")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = bVar2.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    c.a.r0.a.u.e.f.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.f.c)) {
                            cVar = (c.a.r0.a.u.e.f.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.f.c(this.mSwanApiContext);
                            this.mApis.put("1913747800", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.showModal")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = cVar.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    c.a.r0.a.u.e.f.d dVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.f.d)) {
                            dVar = (c.a.r0.a.u.e.f.d) obj;
                        } else {
                            dVar = new c.a.r0.a.u.e.f.d(this.mSwanApiContext);
                            this.mApis.put("-246386074", dVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(dVar, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.showNavigationBarLoading")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b B = dVar.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    i iVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof i)) {
                            iVar = (i) obj;
                        } else {
                            iVar = new i(this.mSwanApiContext);
                            this.mApis.put("1159492510", iVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(iVar, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.showToast")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b Q = iVar.Q(str);
                        return Q == null ? "" : Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    g gVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof g)) {
                            gVar = (g) obj;
                        } else {
                            gVar = new g(this.mSwanApiContext);
                            this.mApis.put("1165118609", gVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(gVar, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.stopPullDownRefresh")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = gVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    c.a.r0.a.u.e.f.f fVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.f.f)) {
                            fVar = (c.a.r0.a.u.e.f.f) obj;
                        } else {
                            fVar = new c.a.r0.a.u.e.f.f(this.mSwanApiContext);
                            this.mApis.put("-108978463", fVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(fVar, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.updateMultiPicker")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b M = fVar.M(str);
                        return M == null ? "" : M.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    c.a.r0.a.u.e.g.a aVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.g.a)) {
                            aVar = (c.a.r0.a.u.e.g.a) obj;
                        } else {
                            aVar = new c.a.r0.a.u.e.g.a(this.mSwanApiContext);
                            this.mApis.put("-137346255", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Keyboard.startKeyboardHeightChange")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b C = aVar.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    c.a.r0.a.u.e.g.a aVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.g.a)) {
                            aVar = (c.a.r0.a.u.e.g.a) obj;
                        } else {
                            aVar = new c.a.r0.a.u.e.g.a(this.mSwanApiContext);
                            this.mApis.put("-137346255", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Keyboard.stopKeyboardHeightChange")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b D = aVar.D();
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    c.a.r0.a.u.e.h.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.h.a)) {
                            aVar = (c.a.r0.a.u.e.h.a) obj;
                        } else {
                            aVar = new c.a.r0.a.u.e.h.a(this.mSwanApiContext);
                            this.mApis.put("-397373095", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "LocationService.getLocation")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = aVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    c.a.r0.a.u.e.h.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.h.a)) {
                            aVar = (c.a.r0.a.u.e.h.a) obj;
                        } else {
                            aVar = new c.a.r0.a.u.e.h.a(this.mSwanApiContext);
                            this.mApis.put("-397373095", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "LocationService.startLocationUpdate")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = aVar.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    c.a.r0.a.u.e.h.a aVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.h.a)) {
                            aVar = (c.a.r0.a.u.e.h.a) obj;
                        } else {
                            aVar = new c.a.r0.a.u.e.h.a(this.mSwanApiContext);
                            this.mApis.put("-397373095", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "LocationService.stopLocationUpdate")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b B = aVar.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    c.a.r0.a.u.e.o.a.b bVar2;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.o.a.b)) {
                            bVar2 = (c.a.r0.a.u.e.o.a.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.o.a.b(this.mSwanApiContext);
                            this.mApis.put("538070032", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = bVar2.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String callService(String str) {
                    c.a.r0.a.u.e.i.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.i.b)) {
                            bVar2 = (c.a.r0.a.u.e.i.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.i.b(this.mSwanApiContext);
                            this.mApis.put("-1076509454", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Network.callService")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = bVar2.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    c.a.r0.a.u.e.i.i iVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.i.i)) {
                            iVar = (c.a.r0.a.u.e.i.i) obj;
                        } else {
                            iVar = new c.a.r0.a.u.e.i.i(this.mSwanApiContext);
                            this.mApis.put("968563034", iVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(iVar, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Network.cancelRequest")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b D = iVar.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    c.a.r0.a.u.e.i.h hVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.i.h)) {
                            hVar = (c.a.r0.a.u.e.i.h) obj;
                        } else {
                            hVar = new c.a.r0.a.u.e.i.h(this.mSwanApiContext);
                            this.mApis.put("453220699", hVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(hVar, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Network.getNetworkType")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = hVar.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    c.a.r0.a.u.e.i.h hVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.i.h)) {
                            hVar = (c.a.r0.a.u.e.i.h) obj;
                        } else {
                            hVar = new c.a.r0.a.u.e.i.h(this.mSwanApiContext);
                            this.mApis.put("453220699", hVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(hVar, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Network.networkStatusChange")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = hVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                @JavascriptInterface
                public String request(JsObject jsObject) {
                    InterceptResult invokeL2;
                    c.a.r0.a.u.e.i.i iVar;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && (invokeL2 = interceptable2.invokeL(1048580, this, jsObject)) != null) {
                        return (String) invokeL2.objValue;
                    }
                    try {
                        c.a.r0.a.u.g.c.c().a("request");
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.i.i)) {
                            iVar = (c.a.r0.a.u.e.i.i) obj;
                        } else {
                            iVar = new c.a.r0.a.u.e.i.i(this.mSwanApiContext);
                            this.mApis.put("968563034", iVar);
                        }
                        Pair<Boolean, a> a2 = c.a.r0.a.u.i.a.a(iVar, "swanAPI/request");
                        if (((Boolean) a2.first).booleanValue()) {
                            a = ((a) a2.second).a();
                        } else if (f.a(this.mSwanApiContext.g(), "Network.request")) {
                            a = new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        } else {
                            Pair<a, JSONObject> t = c.a.r0.a.u.c.d.t(jsObject);
                            if (!((a) t.first).isSuccess()) {
                                a = ((a) t.first).a();
                            } else {
                                JSONObject jSONObject = (JSONObject) t.second;
                                if (jSONObject == null) {
                                    a = a.a.a();
                                } else {
                                    c.a.r0.a.u.h.b V = iVar.V(jSONObject);
                                    a = V == null ? "" : V.a();
                                }
                            }
                        }
                        return a;
                    } finally {
                    }
                }
            });
            hashMap.put("_naPayment", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    c.a.r0.a.t1.m.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof c.a.r0.a.t1.m.a)) {
                            aVar = (c.a.r0.a.t1.m.a) obj;
                        } else {
                            aVar = new c.a.r0.a.t1.m.a(this.mSwanApiContext);
                            this.mApis.put("-336396851", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Payment.chooseCoupon")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = aVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    c.a.r0.a.t1.m.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof c.a.r0.a.t1.m.a)) {
                            aVar = (c.a.r0.a.t1.m.a) obj;
                        } else {
                            aVar = new c.a.r0.a.t1.m.a(this.mSwanApiContext);
                            this.mApis.put("-336396851", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Payment.getPaymentInfo")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = aVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    c.a.r0.a.t1.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof c.a.r0.a.t1.c)) {
                            cVar = (c.a.r0.a.t1.c) obj;
                        } else {
                            cVar = new c.a.r0.a.t1.c(this.mSwanApiContext);
                            this.mApis.put("1854689529", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Payment.requestThirdPayment")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = cVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    c.a.r0.a.t1.m.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof c.a.r0.a.t1.m.a)) {
                            aVar = (c.a.r0.a.t1.m.a) obj;
                        } else {
                            aVar = new c.a.r0.a.t1.m.a(this.mSwanApiContext);
                            this.mApis.put("-336396851", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Payment.setPaymentInfo")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b z = aVar.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    c.a.r0.a.w1.d.a.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof c.a.r0.a.w1.d.a.a)) {
                            aVar = (c.a.r0.a.w1.d.a.a) obj;
                        } else {
                            aVar = new c.a.r0.a.w1.d.a.a(this.mSwanApiContext);
                            this.mApis.put("-254510461", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Plugin.invokePluginChooseAddress")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = aVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    c.a.r0.a.w1.d.a.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof c.a.r0.a.w1.d.a.a)) {
                            aVar = (c.a.r0.a.w1.d.a.a) obj;
                        } else {
                            aVar = new c.a.r0.a.w1.d.a.a(this.mSwanApiContext);
                            this.mApis.put("-254510461", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b z = aVar.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    c.a.r0.a.w1.d.a.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof c.a.r0.a.w1.d.a.a)) {
                            aVar = (c.a.r0.a.w1.d.a.a) obj;
                        } else {
                            aVar = new c.a.r0.a.w1.d.a.a(this.mSwanApiContext);
                            this.mApis.put("-254510461", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Plugin.invokePluginPayment")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = aVar.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    c.a.r0.a.h0.o.f.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof c.a.r0.a.h0.o.f.a)) {
                            aVar = (c.a.r0.a.h0.o.f.a) obj;
                        } else {
                            aVar = new c.a.r0.a.h0.o.f.a(this.mSwanApiContext);
                            this.mApis.put("-2068479848", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Prefetch.prefetchResources")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = aVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    c.a.r0.a.h0.l.g.o.d.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof c.a.r0.a.h0.l.g.o.d.a)) {
                            aVar = (c.a.r0.a.h0.l.g.o.d.a) obj;
                        } else {
                            aVar = new c.a.r0.a.h0.l.g.o.d.a(this.mSwanApiContext);
                            this.mApis.put("423661539", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Preload.preloadStatus")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = aVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    c.a.r0.a.y2.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof c.a.r0.a.y2.b)) {
                            bVar2 = (c.a.r0.a.y2.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.y2.b(this.mSwanApiContext);
                            this.mApis.put("-1929343869", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "PrivateFile.uploadFileToBos")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b C = bVar2.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    c.a.r0.a.u.e.j.b bVar2;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.j.b)) {
                            bVar2 = (c.a.r0.a.u.e.j.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.j.b(this.mSwanApiContext);
                            this.mApis.put("-1495163604", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Router.hideModalPage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = bVar2.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    c.a.r0.a.u.e.j.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.j.b)) {
                            bVar2 = (c.a.r0.a.u.e.j.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.j.b(this.mSwanApiContext);
                            this.mApis.put("-1495163604", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Router.navigateBack")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b B = bVar2.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    c.a.r0.a.u.e.j.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.j.c)) {
                            cVar = (c.a.r0.a.u.e.j.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.j.c(this.mSwanApiContext);
                            this.mApis.put("1968522584", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Router.navigateTo")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b H = cVar.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    c.a.r0.a.u.e.j.e eVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.j.e)) {
                            eVar = (c.a.r0.a.u.e.j.e) obj;
                        } else {
                            eVar = new c.a.r0.a.u.e.j.e(this.mSwanApiContext);
                            this.mApis.put("1317280190", eVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(eVar, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Router.reLaunch")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = eVar.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    c.a.r0.a.u.e.j.f fVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.j.f)) {
                            fVar = (c.a.r0.a.u.e.j.f) obj;
                        } else {
                            fVar = new c.a.r0.a.u.e.j.f(this.mSwanApiContext);
                            this.mApis.put("-420075743", fVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(fVar, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Router.reLoadErrorPage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = fVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    c.a.r0.a.u.e.j.d dVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.j.d)) {
                            dVar = (c.a.r0.a.u.e.j.d) obj;
                        } else {
                            dVar = new c.a.r0.a.u.e.j.d(this.mSwanApiContext);
                            this.mApis.put("1792515533", dVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(dVar, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Router.redirectTo")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b D = dVar.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    c.a.r0.a.u.e.j.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.j.c)) {
                            cVar = (c.a.r0.a.u.e.j.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.j.c(this.mSwanApiContext);
                            this.mApis.put("1968522584", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Router.showModalPage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b J = cVar.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    c.a.r0.a.u.e.k.c cVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.k.c)) {
                            cVar = (c.a.r0.a.u.e.k.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.k.c(this.mSwanApiContext);
                            this.mApis.put("-594895721", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Setting.getAppInfoSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b F = cVar.F();
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    c.a.r0.a.u.e.k.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.k.c)) {
                            cVar = (c.a.r0.a.u.e.k.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.k.c(this.mSwanApiContext);
                            this.mApis.put("-594895721", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Setting.getSetting")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b G = cVar.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    c.a.r0.a.u.e.k.c cVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.k.c)) {
                            cVar = (c.a.r0.a.u.e.k.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.k.c(this.mSwanApiContext);
                            this.mApis.put("-594895721", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Setting.getSlaveIdSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b H = cVar.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    c.a.r0.a.u.e.k.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.k.c)) {
                            cVar = (c.a.r0.a.u.e.k.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.k.c(this.mSwanApiContext);
                            this.mApis.put("-594895721", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Setting.getSwanId")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b I = cVar.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    c.a.r0.a.u.e.k.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.k.c)) {
                            cVar = (c.a.r0.a.u.e.k.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.k.c(this.mSwanApiContext);
                            this.mApis.put("-594895721", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Setting.getUserInfo")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b J = cVar.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    c.a.r0.a.u.e.k.b bVar2;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.k.b)) {
                            bVar2 = (c.a.r0.a.u.e.k.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.k.b(this.mSwanApiContext);
                            this.mApis.put("450273045", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Setting.isAllowedAdOpenAppSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = bVar2.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    r rVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof r)) {
                            rVar = (r) obj;
                        } else {
                            rVar = new r(this.mSwanApiContext);
                            this.mApis.put("712777136", rVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(rVar, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = rVar.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    c.a.r0.a.u.e.l.c cVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.c)) {
                            cVar = (c.a.r0.a.u.e.l.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.l.c(this.mSwanApiContext);
                            this.mApis.put("-804054859", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.clearGlobalStorage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = cVar.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    c.a.r0.a.u.e.l.c cVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.c)) {
                            cVar = (c.a.r0.a.u.e.l.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.l.c(this.mSwanApiContext);
                            this.mApis.put("-804054859", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.clearGlobalStorageSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b C = cVar.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    c.a.r0.a.u.e.l.b bVar2;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.b)) {
                            bVar2 = (c.a.r0.a.u.e.l.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.l.b(this.mSwanApiContext);
                            this.mApis.put("130910081", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.clearStorage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = bVar2.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    c.a.r0.a.u.e.l.b bVar2;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.b)) {
                            bVar2 = (c.a.r0.a.u.e.l.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.l.b(this.mSwanApiContext);
                            this.mApis.put("130910081", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.clearStorageSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b C = bVar2.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    c.a.r0.a.u.e.l.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.c)) {
                            cVar = (c.a.r0.a.u.e.l.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.l.c(this.mSwanApiContext);
                            this.mApis.put("-804054859", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.getGlobalStorage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b D = cVar.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    c.a.r0.a.u.e.l.c cVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.c)) {
                            cVar = (c.a.r0.a.u.e.l.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.l.c(this.mSwanApiContext);
                            this.mApis.put("-804054859", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.getGlobalStorageInfo")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b G = cVar.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    c.a.r0.a.u.e.l.c cVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.c)) {
                            cVar = (c.a.r0.a.u.e.l.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.l.c(this.mSwanApiContext);
                            this.mApis.put("-804054859", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.getGlobalStorageInfoSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b J = cVar.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    c.a.r0.a.u.e.l.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.c)) {
                            cVar = (c.a.r0.a.u.e.l.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.l.c(this.mSwanApiContext);
                            this.mApis.put("-804054859", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.getGlobalStorageSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b K = cVar.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    c.a.r0.a.u.e.l.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.b)) {
                            bVar2 = (c.a.r0.a.u.e.l.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.l.b(this.mSwanApiContext);
                            this.mApis.put("130910081", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.getStorage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b D = bVar2.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    c.a.r0.a.u.e.l.b bVar2;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.b)) {
                            bVar2 = (c.a.r0.a.u.e.l.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.l.b(this.mSwanApiContext);
                            this.mApis.put("130910081", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.getStorageInfo")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b G = bVar2.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    c.a.r0.a.u.e.l.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.b)) {
                            bVar2 = (c.a.r0.a.u.e.l.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.l.b(this.mSwanApiContext);
                            this.mApis.put("130910081", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.getStorageInfoAsync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b H = bVar2.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    c.a.r0.a.u.e.l.b bVar2;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.b)) {
                            bVar2 = (c.a.r0.a.u.e.l.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.l.b(this.mSwanApiContext);
                            this.mApis.put("130910081", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.getStorageInfoSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b J = bVar2.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    c.a.r0.a.u.e.l.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.b)) {
                            bVar2 = (c.a.r0.a.u.e.l.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.l.b(this.mSwanApiContext);
                            this.mApis.put("130910081", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.getStorageSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b K = bVar2.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    c.a.r0.a.u.e.l.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.c)) {
                            cVar = (c.a.r0.a.u.e.l.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.l.c(this.mSwanApiContext);
                            this.mApis.put("-804054859", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.removeGlobalStorage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b R = cVar.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    c.a.r0.a.u.e.l.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.c)) {
                            cVar = (c.a.r0.a.u.e.l.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.l.c(this.mSwanApiContext);
                            this.mApis.put("-804054859", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.removeGlobalStorageSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b T = cVar.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    c.a.r0.a.u.e.l.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.b)) {
                            bVar2 = (c.a.r0.a.u.e.l.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.l.b(this.mSwanApiContext);
                            this.mApis.put("130910081", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.removeStorage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b R = bVar2.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    c.a.r0.a.u.e.l.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.b)) {
                            bVar2 = (c.a.r0.a.u.e.l.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.l.b(this.mSwanApiContext);
                            this.mApis.put("130910081", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.removeStorageSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b T = bVar2.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    c.a.r0.a.u.e.l.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.c)) {
                            cVar = (c.a.r0.a.u.e.l.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.l.c(this.mSwanApiContext);
                            this.mApis.put("-804054859", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.setGlobalStorage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b U = cVar.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    c.a.r0.a.u.e.l.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.c)) {
                            cVar = (c.a.r0.a.u.e.l.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.l.c(this.mSwanApiContext);
                            this.mApis.put("-804054859", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.setGlobalStorageSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b W = cVar.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    c.a.r0.a.u.e.l.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.b)) {
                            bVar2 = (c.a.r0.a.u.e.l.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.l.b(this.mSwanApiContext);
                            this.mApis.put("130910081", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.setStorage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b U = bVar2.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    c.a.r0.a.u.e.l.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.b)) {
                            bVar2 = (c.a.r0.a.u.e.l.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.l.b(this.mSwanApiContext);
                            this.mApis.put("130910081", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.setStorageSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b W = bVar2.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    c.a.r0.a.u.e.m.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.m.b)) {
                            bVar2 = (c.a.r0.a.u.e.m.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.m.b(this.mSwanApiContext);
                            this.mApis.put("823117982", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Subscription.requestSubscribeFormId")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b E = bVar2.E(str);
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    c.a.r0.a.u.e.m.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.m.c)) {
                            cVar = (c.a.r0.a.u.e.m.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.m.c(this.mSwanApiContext);
                            this.mApis.put("-947445811", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Subscription.subscribeService")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b F = cVar.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    c.a.r0.a.u.e.n.g gVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.n.g)) {
                            gVar = (c.a.r0.a.u.e.n.g) obj;
                        } else {
                            gVar = new c.a.r0.a.u.e.n.g(this.mSwanApiContext);
                            this.mApis.put("1936205521", gVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(gVar, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.exitFullScreen")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = gVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    c.a.r0.a.u.e.n.c cVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.n.c)) {
                            cVar = (c.a.r0.a.u.e.n.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.n.c(this.mSwanApiContext);
                            this.mApis.put("99997465", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.getBrightness")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = cVar.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    c.a.r0.a.u.e.n.d dVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.n.d)) {
                            dVar = (c.a.r0.a.u.e.n.d) obj;
                        } else {
                            dVar = new c.a.r0.a.u.e.n.d(this.mSwanApiContext);
                            this.mApis.put("-518757484", dVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(dVar, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.getClipboardData")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = dVar.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    c.a.r0.a.u.e.n.f fVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.n.f)) {
                            fVar = (c.a.r0.a.u.e.n.f) obj;
                        } else {
                            fVar = new c.a.r0.a.u.e.n.f(this.mSwanApiContext);
                            this.mApis.put("1694151270", fVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(fVar, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.getDeviceInfo")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = fVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    c.a.r0.a.u.e.n.h hVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.n.h)) {
                            hVar = (c.a.r0.a.u.e.n.h) obj;
                        } else {
                            hVar = new c.a.r0.a.u.e.n.h(this.mSwanApiContext);
                            this.mApis.put("-1321681619", hVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(hVar, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.getDeviceProfile")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = hVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    n nVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof n)) {
                            nVar = (n) obj;
                        } else {
                            nVar = new n(this.mSwanApiContext);
                            this.mApis.put("447234992", nVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(nVar, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.getMediaVolume")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = nVar.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    c.a.r0.a.u.e.n.i iVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.n.i)) {
                            iVar = (c.a.r0.a.u.e.n.i) obj;
                        } else {
                            iVar = new c.a.r0.a.u.e.n.i(this.mSwanApiContext);
                            this.mApis.put("-1569246082", iVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(iVar, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.makePhoneCall")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = iVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    k kVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof k)) {
                            kVar = (k) obj;
                        } else {
                            kVar = new k(this.mSwanApiContext);
                            this.mApis.put("1099851202", kVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(kVar, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.openSMSPanel")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = kVar.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    c.a.r0.a.u.e.n.j jVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.n.j)) {
                            jVar = (c.a.r0.a.u.e.n.j) obj;
                        } else {
                            jVar = new c.a.r0.a.u.e.n.j(this.mSwanApiContext);
                            this.mApis.put("-1707203360", jVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(jVar, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.requestFullScreen")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b F = jVar.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    c.a.r0.a.u.e.n.d dVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.n.d)) {
                            dVar = (c.a.r0.a.u.e.n.d) obj;
                        } else {
                            dVar = new c.a.r0.a.u.e.n.d(this.mSwanApiContext);
                            this.mApis.put("-518757484", dVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(dVar, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.setClipboardData")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = dVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    c.a.r0.a.k1.d dVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof c.a.r0.a.k1.d)) {
                            dVar = (c.a.r0.a.k1.d) obj;
                        } else {
                            dVar = new c.a.r0.a.k1.d(this.mSwanApiContext);
                            this.mApis.put("1161486049", dVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(dVar, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.setErrorPageType")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = dVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    n nVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof n)) {
                            nVar = (n) obj;
                        } else {
                            nVar = new n(this.mSwanApiContext);
                            this.mApis.put("447234992", nVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(nVar, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.setMediaVolume")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b z = nVar.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    c.a.r0.a.u.e.n.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.n.b)) {
                            bVar2 = (c.a.r0.a.u.e.n.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.n.b(this.mSwanApiContext);
                            this.mApis.put("1372680763", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.startAccelerometer")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = bVar2.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    c.a.r0.a.u.e.n.e eVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.n.e)) {
                            eVar = (c.a.r0.a.u.e.n.e) obj;
                        } else {
                            eVar = new c.a.r0.a.u.e.n.e(this.mSwanApiContext);
                            this.mApis.put("1689255576", eVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(eVar, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.startCompass")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = eVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    c.a.r0.a.u.e.n.b bVar2;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.n.b)) {
                            bVar2 = (c.a.r0.a.u.e.n.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.n.b(this.mSwanApiContext);
                            this.mApis.put("1372680763", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.stopAccelerometer")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b B = bVar2.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    c.a.r0.a.u.e.n.e eVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.n.e)) {
                            eVar = (c.a.r0.a.u.e.n.e) obj;
                        } else {
                            eVar = new c.a.r0.a.u.e.n.e(this.mSwanApiContext);
                            this.mApis.put("1689255576", eVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(eVar, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.stopCompass")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b z = eVar.z();
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    c.a.r0.a.u.e.p.f fVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.p.f)) {
                            fVar = (c.a.r0.a.u.e.p.f) obj;
                        } else {
                            fVar = new c.a.r0.a.u.e.p.f(this.mSwanApiContext);
                            this.mApis.put("201194468", fVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(fVar, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.addToDesktop")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b B = fVar.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    c.a.r0.a.u.e.p.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.p.b)) {
                            bVar2 = (c.a.r0.a.u.e.p.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.p.b(this.mSwanApiContext);
                            this.mApis.put("-1412306947", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.calcMD5")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = bVar2.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    c.a.r0.a.u.e.p.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.p.c)) {
                            cVar = (c.a.r0.a.u.e.p.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.p.c(this.mSwanApiContext);
                            this.mApis.put("1626415364", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.checkAppInstalled")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = cVar.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    c.a.r0.a.u.e.p.e eVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.p.e)) {
                            eVar = (c.a.r0.a.u.e.p.e) obj;
                        } else {
                            eVar = new c.a.r0.a.u.e.p.e(this.mSwanApiContext);
                            this.mApis.put("-836768778", eVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(eVar, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.getCommonSysInfo")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = eVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    c.a.r0.a.u.e.p.k kVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.p.k)) {
                            kVar = (c.a.r0.a.u.e.p.k) obj;
                        } else {
                            kVar = new c.a.r0.a.u.e.p.k(this.mSwanApiContext);
                            this.mApis.put("-1011537871", kVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(kVar, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.getCommonSysInfoSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b E = kVar.E();
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    c.a.r0.a.u.e.p.g gVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.p.g)) {
                            gVar = (c.a.r0.a.u.e.p.g) obj;
                        } else {
                            gVar = new c.a.r0.a.u.e.p.g(this.mSwanApiContext);
                            this.mApis.put("-810858308", gVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(gVar, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.getPerformanceLevel")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = gVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    c.a.r0.a.u.e.p.k kVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.p.k)) {
                            kVar = (c.a.r0.a.u.e.p.k) obj;
                        } else {
                            kVar = new c.a.r0.a.u.e.p.k(this.mSwanApiContext);
                            this.mApis.put("-1011537871", kVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(kVar, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.getSystemInfo")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b H = kVar.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    c.a.r0.a.u.e.p.k kVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.p.k)) {
                            kVar = (c.a.r0.a.u.e.p.k) obj;
                        } else {
                            kVar = new c.a.r0.a.u.e.p.k(this.mSwanApiContext);
                            this.mApis.put("-1011537871", kVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(kVar, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.getSystemInfoAsync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b I = kVar.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    c.a.r0.a.u.e.p.k kVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.p.k)) {
                            kVar = (c.a.r0.a.u.e.p.k) obj;
                        } else {
                            kVar = new c.a.r0.a.u.e.p.k(this.mSwanApiContext);
                            this.mApis.put("-1011537871", kVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(kVar, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.getSystemInfoSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b J = kVar.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    c.a.r0.a.u.e.p.h hVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.p.h)) {
                            hVar = (c.a.r0.a.u.e.p.h) obj;
                        } else {
                            hVar = new c.a.r0.a.u.e.p.h(this.mSwanApiContext);
                            this.mApis.put("-2097727681", hVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(hVar, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.handleException")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = hVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    c.a.r0.a.u.e.p.d dVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.p.d)) {
                            dVar = (c.a.r0.a.u.e.p.d) obj;
                        } else {
                            dVar = new c.a.r0.a.u.e.p.d(this.mSwanApiContext);
                            this.mApis.put("2084449317", dVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(dVar, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.hasCloseHandler")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = dVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    c.a.r0.a.g2.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof c.a.r0.a.g2.b)) {
                            bVar2 = (c.a.r0.a.g2.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.g2.b(this.mSwanApiContext);
                            this.mApis.put("1031678042", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.hideCaptureScreenShareDialog")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = bVar2.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    c.a.r0.a.u.e.p.i iVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.p.i)) {
                            iVar = (c.a.r0.a.u.e.p.i) obj;
                        } else {
                            iVar = new c.a.r0.a.u.e.p.i(this.mSwanApiContext);
                            this.mApis.put("1751900130", iVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(iVar, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.logToFile")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = iVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    c.a.r0.a.f2.f.m0.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof c.a.r0.a.f2.f.m0.b)) {
                            bVar2 = (c.a.r0.a.f2.f.m0.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.f2.f.m0.b(this.mSwanApiContext);
                            this.mApis.put("1748196865", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.preloadPackage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = bVar2.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    c.a.r0.a.u.e.p.j jVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.p.j)) {
                            jVar = (c.a.r0.a.u.e.p.j) obj;
                        } else {
                            jVar = new c.a.r0.a.u.e.p.j(this.mSwanApiContext);
                            this.mApis.put("589529211", jVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(jVar, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.previewImage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b B = jVar.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    m mVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof m)) {
                            mVar = (m) obj;
                        } else {
                            mVar = new m(this.mSwanApiContext);
                            this.mApis.put("-577481801", mVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(mVar, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.ubcFlowJar")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b I = mVar.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    c.a.r0.a.r2.l.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof c.a.r0.a.r2.l.a)) {
                            aVar = (c.a.r0.a.r2.l.a) obj;
                        } else {
                            aVar = new c.a.r0.a.r2.l.a(this.mSwanApiContext);
                            this.mApis.put("1879401452", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Wifi.connectWifi")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = aVar.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    c.a.r0.a.r2.l.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof c.a.r0.a.r2.l.a)) {
                            aVar = (c.a.r0.a.r2.l.a) obj;
                        } else {
                            aVar = new c.a.r0.a.r2.l.a(this.mSwanApiContext);
                            this.mApis.put("1879401452", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Wifi.getConnectedWifi")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b B = aVar.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    c.a.r0.a.r2.l.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof c.a.r0.a.r2.l.a)) {
                            aVar = (c.a.r0.a.r2.l.a) obj;
                        } else {
                            aVar = new c.a.r0.a.r2.l.a(this.mSwanApiContext);
                            this.mApis.put("1879401452", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Wifi.getWifiList")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b C = aVar.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    c.a.r0.a.r2.l.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof c.a.r0.a.r2.l.a)) {
                            aVar = (c.a.r0.a.r2.l.a) obj;
                        } else {
                            aVar = new c.a.r0.a.r2.l.a(this.mSwanApiContext);
                            this.mApis.put("1879401452", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Wifi.startWifi")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b G = aVar.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    c.a.r0.a.r2.l.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof c.a.r0.a.r2.l.a)) {
                            aVar = (c.a.r0.a.r2.l.a) obj;
                        } else {
                            aVar = new c.a.r0.a.r2.l.a(this.mSwanApiContext);
                            this.mApis.put("1879401452", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Wifi.stopWifi")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b H = aVar.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static Map<String, Object> getWebviewApiModules(final b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bVar)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naAccount", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$AccountWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String checkSession(String str) {
                    c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1930258908");
                        if (obj != null && (obj instanceof c)) {
                            cVar = (c) obj;
                        } else {
                            cVar = new c(this.mSwanApiContext);
                            this.mApis.put("1930258908", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/checkSession");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Account.checkSession")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = cVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getLoginCode(String str) {
                    d dVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof d)) {
                            dVar = (d) obj;
                        } else {
                            dVar = new d(this.mSwanApiContext);
                            this.mApis.put("-1017914143", dVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(dVar, "swanAPI/getLoginCode");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Account.getLoginCode")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b C = dVar.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getOpenId(String str) {
                    e eVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1754780133");
                        if (obj != null && (obj instanceof e)) {
                            eVar = (e) obj;
                        } else {
                            eVar = new e(this.mSwanApiContext);
                            this.mApis.put("1754780133", eVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(eVar, "swanAPI/getOpenId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Account.getOpenId")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = eVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUnionBDUSS(String str) {
                    c.a.r0.a.s.a.i.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-343998465");
                        if (obj != null && (obj instanceof c.a.r0.a.s.a.i.a)) {
                            aVar = (c.a.r0.a.s.a.i.a) obj;
                        } else {
                            aVar = new c.a.r0.a.s.a.i.a(this.mSwanApiContext);
                            this.mApis.put("-343998465", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/getUnionBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Account.getUnionBDUSS")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = aVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isBaiduAccountSync() {
                    c.a.r0.a.u.e.a.b bVar2;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-337742792");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.a.b)) {
                            bVar2 = (c.a.r0.a.u.e.a.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.a.b(this.mSwanApiContext);
                            this.mApis.put("-337742792", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/isBaiduAccountSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Account.isBaiduAccountSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = bVar2.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String isLoginSync() {
                    d dVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof d)) {
                            dVar = (d) obj;
                        } else {
                            dVar = new d(this.mSwanApiContext);
                            this.mApis.put("-1017914143", dVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(dVar, "swanAPI/isLoginSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Account.isLoginSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b H = dVar.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String login(String str) {
                    d dVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1017914143");
                        if (obj != null && (obj instanceof d)) {
                            dVar = (d) obj;
                        } else {
                            dVar = new d(this.mSwanApiContext);
                            this.mApis.put("-1017914143", dVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(dVar, "swanAPI/login");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Account.login")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b I = dVar.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBasic", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$BasicWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String loadSubPackage(String str) {
                    c.a.r0.a.u.e.b.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.b.a)) {
                            aVar = (c.a.r0.a.u.e.b.a) obj;
                        } else {
                            aVar = new c.a.r0.a.u.e.b.a(this.mSwanApiContext);
                            this.mApis.put("-1249666566", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/loadSubPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Basic.loadSubPackage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b F = aVar.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String loadSubPackages(String str) {
                    c.a.r0.a.u.e.b.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1249666566");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.b.a)) {
                            aVar = (c.a.r0.a.u.e.b.a) obj;
                        } else {
                            aVar = new c.a.r0.a.u.e.b.a(this.mSwanApiContext);
                            this.mApis.put("-1249666566", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/loadSubPackages");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Basic.loadSubPackages")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b G = aVar.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naBookshelf", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$BookshelfWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String deleteBookshelf(String str) {
                    c.a.r0.a.n.b.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof c.a.r0.a.n.b.a)) {
                            aVar = (c.a.r0.a.n.b.a) obj;
                        } else {
                            aVar = new c.a.r0.a.n.b.a(this.mSwanApiContext);
                            this.mApis.put("1460300387", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/bookshelf/deleteBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Bookshelf.deleteBookshelf")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b K = aVar.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String insertBookshelf(String str) {
                    c.a.r0.a.n.b.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof c.a.r0.a.n.b.a)) {
                            aVar = (c.a.r0.a.n.b.a) obj;
                        } else {
                            aVar = new c.a.r0.a.n.b.a(this.mSwanApiContext);
                            this.mApis.put("1460300387", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/bookshelf/insertBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Bookshelf.insertBookshelf")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b P = aVar.P(str);
                        return P == null ? "" : P.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateToBookshelf(String str) {
                    c.a.r0.a.n.b.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof c.a.r0.a.n.b.a)) {
                            aVar = (c.a.r0.a.n.b.a) obj;
                        } else {
                            aVar = new c.a.r0.a.n.b.a(this.mSwanApiContext);
                            this.mApis.put("1460300387", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/bookshelf/navigateToBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Bookshelf.navigateToBookshelf")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b U = aVar.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryBookshelf(String str) {
                    c.a.r0.a.n.b.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof c.a.r0.a.n.b.a)) {
                            aVar = (c.a.r0.a.n.b.a) obj;
                        } else {
                            aVar = new c.a.r0.a.n.b.a(this.mSwanApiContext);
                            this.mApis.put("1460300387", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/bookshelf/queryBookshelf");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Bookshelf.queryBookshelf")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b V = aVar.V(str);
                        return V == null ? "" : V.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateBookshelfReadTime(String str) {
                    c.a.r0.a.n.b.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1460300387");
                        if (obj != null && (obj instanceof c.a.r0.a.n.b.a)) {
                            aVar = (c.a.r0.a.n.b.a) obj;
                        } else {
                            aVar = new c.a.r0.a.n.b.a(this.mSwanApiContext);
                            this.mApis.put("1460300387", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/bookshelf/updateBookshelfReadTime");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Bookshelf.updateBookshelfReadTime")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b X = aVar.X(str);
                        return X == null ? "" : X.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naCoupon", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$CouponWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String getPlatformCoupons(String str) {
                    c.a.r0.a.u.d.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof c.a.r0.a.u.d.a)) {
                            aVar = (c.a.r0.a.u.d.a) obj;
                        } else {
                            aVar = new c.a.r0.a.u.d.a(this.mSwanApiContext);
                            this.mApis.put("-277316359", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/coupon/getPlatformCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Coupon.getPlatformCoupons")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = aVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserCoupons(String str) {
                    c.a.r0.a.u.d.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof c.a.r0.a.u.d.a)) {
                            aVar = (c.a.r0.a.u.d.a) obj;
                        } else {
                            aVar = new c.a.r0.a.u.d.a(this.mSwanApiContext);
                            this.mApis.put("-277316359", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/coupon/getUserCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Coupon.getUserCoupons")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b z = aVar.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String takeCoupons(String str) {
                    c.a.r0.a.u.d.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-277316359");
                        if (obj != null && (obj instanceof c.a.r0.a.u.d.a)) {
                            aVar = (c.a.r0.a.u.d.a) obj;
                        } else {
                            aVar = new c.a.r0.a.u.d.a(this.mSwanApiContext);
                            this.mApis.put("-277316359", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/coupon/takeCoupons");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Coupon.takeCoupons")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b C = aVar.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFavorite", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$FavoriteWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String getFavorStatus(String str) {
                    c.a.r0.a.u.e.c.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1225406515");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.c.b)) {
                            bVar2 = (c.a.r0.a.u.e.c.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.c.b(this.mSwanApiContext);
                            this.mApis.put("-1225406515", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/getFavorStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Favorite.getFavorStatus")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = bVar2.x(str);
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
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(showFavoriteGuideApi, "swanAPI/showFavoriteGuide");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Favorite.showFavoriteGuide")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b G = showFavoriteGuideApi.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naFile", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$FileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String shareFile(String str) {
                    c.a.r0.a.u.e.d.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2057135077");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.d.a)) {
                            aVar = (c.a.r0.a.u.e.d.a) obj;
                        } else {
                            aVar = new c.a.r0.a.u.e.d.a(this.mSwanApiContext);
                            this.mApis.put("-2057135077", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/shareFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "File.shareFile")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = aVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naGameCenter", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$GameCenterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String postGameCenterMessage(String str) {
                    c.a.r0.a.u0.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof c.a.r0.a.u0.a)) {
                            aVar = (c.a.r0.a.u0.a) obj;
                        } else {
                            aVar = new c.a.r0.a.u0.a(this.mSwanApiContext);
                            this.mApis.put("2077414795", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/postGameCenterMessage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "GameCenter.postGameCenterMessage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = aVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String postGameCenterMessageSync(String str) {
                    c.a.r0.a.u0.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("2077414795");
                        if (obj != null && (obj instanceof c.a.r0.a.u0.a)) {
                            aVar = (c.a.r0.a.u0.a) obj;
                        } else {
                            aVar = new c.a.r0.a.u0.a(this.mSwanApiContext);
                            this.mApis.put("2077414795", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/postGameCenterMessageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "GameCenter.postGameCenterMessageSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = aVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naHostDownloadManager", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$HostDownloadManagerWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String download(String str) {
                    c.a.r0.a.u.e.d.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.d.b)) {
                            bVar2 = (c.a.r0.a.u.e.d.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.d.b(this.mSwanApiContext);
                            this.mApis.put("-170124576", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/download");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "HostDownloadManager.download")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = bVar2.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openDownloadCenter() {
                    c.a.r0.a.u.e.d.b bVar2;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.d.b)) {
                            bVar2 = (c.a.r0.a.u.e.d.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.d.b(this.mSwanApiContext);
                            this.mApis.put("-170124576", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/openDownloadCenter");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "HostDownloadManager.openDownloadCenter")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = bVar2.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openFile(String str) {
                    c.a.r0.a.u.e.d.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.d.b)) {
                            bVar2 = (c.a.r0.a.u.e.d.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.d.b(this.mSwanApiContext);
                            this.mApis.put("-170124576", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/openFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "HostDownloadManager.openFile")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b z = bVar2.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String query(String str) {
                    c.a.r0.a.u.e.d.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-170124576");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.d.b)) {
                            bVar2 = (c.a.r0.a.u.e.d.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.d.b(this.mSwanApiContext);
                            this.mApis.put("-170124576", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/query");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "HostDownloadManager.query")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b query = bVar2.query(str);
                        return query == null ? "" : query.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naImage", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$ImageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String callImageMenu(String str) {
                    c.a.r0.a.k1.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1445003743");
                        if (obj != null && (obj instanceof c.a.r0.a.k1.b)) {
                            bVar2 = (c.a.r0.a.k1.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.k1.b(this.mSwanApiContext);
                            this.mApis.put("1445003743", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/callImageMenu");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Image.callImageMenu")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = bVar2.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String compressImage(String str) {
                    c.a.r0.a.u.e.e.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1252730367");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.e.b)) {
                            bVar2 = (c.a.r0.a.u.e.e.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.e.b(this.mSwanApiContext);
                            this.mApis.put("-1252730367", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/compressImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Image.compressImage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = bVar2.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naInteraction", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$InteractionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String closeTabBar(String str) {
                    h hVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof h)) {
                            hVar = (h) obj;
                        } else {
                            hVar = new h(this.mSwanApiContext);
                            this.mApis.put("-1871435471", hVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(hVar, "swanAPI/closeTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.closeTabBar")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = hVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String closeTabBarRedDot(String str) {
                    h hVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof h)) {
                            hVar = (h) obj;
                        } else {
                            hVar = new h(this.mSwanApiContext);
                            this.mApis.put("-1871435471", hVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(hVar, "swanAPI/closeTabBarRedDot");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.closeTabBarRedDot")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = hVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideLoading() {
                    c.a.r0.a.u.e.f.b bVar2;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.f.b)) {
                            bVar2 = (c.a.r0.a.u.e.f.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.f.b(this.mSwanApiContext);
                            this.mApis.put("5236036", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/hideLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.hideLoading")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = bVar2.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String hideNavigationBarLoading(String str) {
                    c.a.r0.a.u.e.f.d dVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.f.d)) {
                            dVar = (c.a.r0.a.u.e.f.d) obj;
                        } else {
                            dVar = new c.a.r0.a.u.e.f.d(this.mSwanApiContext);
                            this.mApis.put("-246386074", dVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(dVar, "swanAPI/hideNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.hideNavigationBarLoading")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = dVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideToast() {
                    i iVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof i)) {
                            iVar = (i) obj;
                        } else {
                            iVar = new i(this.mSwanApiContext);
                            this.mApis.put("1159492510", iVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(iVar, "swanAPI/hideToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.hideToast")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b K = iVar.K();
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String openMultiPicker(String str) {
                    c.a.r0.a.u.e.f.f fVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.f.f)) {
                            fVar = (c.a.r0.a.u.e.f.f) obj;
                        } else {
                            fVar = new c.a.r0.a.u.e.f.f(this.mSwanApiContext);
                            this.mApis.put("-108978463", fVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(fVar, "swanAPI/openMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.openMultiPicker")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b G = fVar.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openPicker(String str) {
                    c.a.r0.a.u.e.f.f fVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.f.f)) {
                            fVar = (c.a.r0.a.u.e.f.f) obj;
                        } else {
                            fVar = new c.a.r0.a.u.e.f.f(this.mSwanApiContext);
                            this.mApis.put("-108978463", fVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(fVar, "swanAPI/openPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.openPicker")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b H = fVar.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openTabBar(String str) {
                    h hVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof h)) {
                            hVar = (h) obj;
                        } else {
                            hVar = new h(this.mSwanApiContext);
                            this.mApis.put("-1871435471", hVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(hVar, "swanAPI/openTabBar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.openTabBar")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b C = hVar.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String pageScrollTo(String str) {
                    c.a.r0.a.u.e.f.e eVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1750613704");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.f.e)) {
                            eVar = (c.a.r0.a.u.e.f.e) obj;
                        } else {
                            eVar = new c.a.r0.a.u.e.f.e(this.mSwanApiContext);
                            this.mApis.put("-1750613704", eVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(eVar, "swanAPI/pageScrollTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.pageScrollTo")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = eVar.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarColor(String str) {
                    c.a.r0.a.u.e.f.d dVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.f.d)) {
                            dVar = (c.a.r0.a.u.e.f.d) obj;
                        } else {
                            dVar = new c.a.r0.a.u.e.f.d(this.mSwanApiContext);
                            this.mApis.put("-246386074", dVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(dVar, "swanAPI/setNavigationBarColor");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.setNavigationBarColor")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b z = dVar.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setNavigationBarTitle(String str) {
                    c.a.r0.a.u.e.f.d dVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.f.d)) {
                            dVar = (c.a.r0.a.u.e.f.d) obj;
                        } else {
                            dVar = new c.a.r0.a.u.e.f.d(this.mSwanApiContext);
                            this.mApis.put("-246386074", dVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(dVar, "swanAPI/setNavigationBarTitle");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.setNavigationBarTitle")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = dVar.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setTabBarItem(String str) {
                    h hVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("-1871435471");
                        if (obj != null && (obj instanceof h)) {
                            hVar = (h) obj;
                        } else {
                            hVar = new h(this.mSwanApiContext);
                            this.mApis.put("-1871435471", hVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(hVar, "swanAPI/setTabBarItem");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.setTabBarItem")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b D = hVar.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showDatePickerView(String str) {
                    c.a.r0.a.u.e.f.f fVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.f.f)) {
                            fVar = (c.a.r0.a.u.e.f.f) obj;
                        } else {
                            fVar = new c.a.r0.a.u.e.f.f(this.mSwanApiContext);
                            this.mApis.put("-108978463", fVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(fVar, "swanAPI/showDatePickerView");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.showDatePickerView")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b L = fVar.L(str);
                        return L == null ? "" : L.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showHalfScreenWebview(String str) {
                    j jVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1172469410");
                        if (obj != null && (obj instanceof j)) {
                            jVar = (j) obj;
                        } else {
                            jVar = new j(this.mSwanApiContext);
                            this.mApis.put("1172469410", jVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(jVar, "swanAPI/showHalfScreenWebview");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.showHalfScreenWebview")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b K = jVar.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showLoading(String str) {
                    c.a.r0.a.u.e.f.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("5236036");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.f.b)) {
                            bVar2 = (c.a.r0.a.u.e.f.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.f.b(this.mSwanApiContext);
                            this.mApis.put("5236036", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/showLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.showLoading")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = bVar2.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModal(String str) {
                    c.a.r0.a.u.e.f.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("1913747800");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.f.c)) {
                            cVar = (c.a.r0.a.u.e.f.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.f.c(this.mSwanApiContext);
                            this.mApis.put("1913747800", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/showModal");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.showModal")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = cVar.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showNavigationBarLoading(String str) {
                    c.a.r0.a.u.e.f.d dVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("-246386074");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.f.d)) {
                            dVar = (c.a.r0.a.u.e.f.d) obj;
                        } else {
                            dVar = new c.a.r0.a.u.e.f.d(this.mSwanApiContext);
                            this.mApis.put("-246386074", dVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(dVar, "swanAPI/showNavigationBarLoading");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.showNavigationBarLoading")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b B = dVar.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showToast(String str) {
                    i iVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("1159492510");
                        if (obj != null && (obj instanceof i)) {
                            iVar = (i) obj;
                        } else {
                            iVar = new i(this.mSwanApiContext);
                            this.mApis.put("1159492510", iVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(iVar, "swanAPI/showToast");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.showToast")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b Q = iVar.Q(str);
                        return Q == null ? "" : Q.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopPullDownRefresh(String str) {
                    g gVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("1165118609");
                        if (obj != null && (obj instanceof g)) {
                            gVar = (g) obj;
                        } else {
                            gVar = new g(this.mSwanApiContext);
                            this.mApis.put("1165118609", gVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(gVar, "swanAPI/stopPullDownRefresh");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.stopPullDownRefresh")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = gVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String updateMultiPicker(String str) {
                    c.a.r0.a.u.e.f.f fVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("-108978463");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.f.f)) {
                            fVar = (c.a.r0.a.u.e.f.f) obj;
                        } else {
                            fVar = new c.a.r0.a.u.e.f.f(this.mSwanApiContext);
                            this.mApis.put("-108978463", fVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(fVar, "swanAPI/updateMultiPicker");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Interaction.updateMultiPicker")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b M = fVar.M(str);
                        return M == null ? "" : M.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naKeyboard", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$KeyboardWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String startKeyboardHeightChange() {
                    c.a.r0.a.u.e.g.a aVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.g.a)) {
                            aVar = (c.a.r0.a.u.e.g.a) obj;
                        } else {
                            aVar = new c.a.r0.a.u.e.g.a(this.mSwanApiContext);
                            this.mApis.put("-137346255", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/startKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Keyboard.startKeyboardHeightChange")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b C = aVar.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopKeyboardHeightChange() {
                    c.a.r0.a.u.e.g.a aVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-137346255");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.g.a)) {
                            aVar = (c.a.r0.a.u.e.g.a) obj;
                        } else {
                            aVar = new c.a.r0.a.u.e.g.a(this.mSwanApiContext);
                            this.mApis.put("-137346255", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/stopKeyboardHeightChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Keyboard.stopKeyboardHeightChange")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b D = aVar.D();
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naLocationService", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$LocationServiceWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String getLocation(String str) {
                    c.a.r0.a.u.e.h.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.h.a)) {
                            aVar = (c.a.r0.a.u.e.h.a) obj;
                        } else {
                            aVar = new c.a.r0.a.u.e.h.a(this.mSwanApiContext);
                            this.mApis.put("-397373095", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/getLocation");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "LocationService.getLocation")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = aVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startLocationUpdate(String str) {
                    c.a.r0.a.u.e.h.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.h.a)) {
                            aVar = (c.a.r0.a.u.e.h.a) obj;
                        } else {
                            aVar = new c.a.r0.a.u.e.h.a(this.mSwanApiContext);
                            this.mApis.put("-397373095", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/startLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "LocationService.startLocationUpdate")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = aVar.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopLocationUpdate() {
                    c.a.r0.a.u.e.h.a aVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-397373095");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.h.a)) {
                            aVar = (c.a.r0.a.u.e.h.a) obj;
                        } else {
                            aVar = new c.a.r0.a.u.e.h.a(this.mSwanApiContext);
                            this.mApis.put("-397373095", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/stopLocationUpdate");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "LocationService.stopLocationUpdate")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b B = aVar.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naMenu", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$MenuWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String getMenuButtonBoundingClientRect() {
                    c.a.r0.a.u.e.o.a.b bVar2;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("538070032");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.o.a.b)) {
                            bVar2 = (c.a.r0.a.u.e.o.a.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.o.a.b(this.mSwanApiContext);
                            this.mApis.put("538070032", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/getMenuButtonBoundingClientRect");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Menu.getMenuButtonBoundingClientRect")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = bVar2.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naNetwork", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$NetworkWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String callService(String str) {
                    c.a.r0.a.u.e.i.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1076509454");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.i.b)) {
                            bVar2 = (c.a.r0.a.u.e.i.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.i.b(this.mSwanApiContext);
                            this.mApis.put("-1076509454", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/callService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Network.callService")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = bVar2.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String cancelRequest(String str) {
                    c.a.r0.a.u.e.i.i iVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.i.i)) {
                            iVar = (c.a.r0.a.u.e.i.i) obj;
                        } else {
                            iVar = new c.a.r0.a.u.e.i.i(this.mSwanApiContext);
                            this.mApis.put("968563034", iVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(iVar, "swanAPI/cancelRequest");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Network.cancelRequest")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b D = iVar.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getNetworkType() {
                    c.a.r0.a.u.e.i.h hVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.i.h)) {
                            hVar = (c.a.r0.a.u.e.i.h) obj;
                        } else {
                            hVar = new c.a.r0.a.u.e.i.h(this.mSwanApiContext);
                            this.mApis.put("453220699", hVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(hVar, "swanAPI/getNetworkType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Network.getNetworkType")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = hVar.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String networkStatusChange(String str) {
                    c.a.r0.a.u.e.i.h hVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("453220699");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.i.h)) {
                            hVar = (c.a.r0.a.u.e.i.h) obj;
                        } else {
                            hVar = new c.a.r0.a.u.e.i.h(this.mSwanApiContext);
                            this.mApis.put("453220699", hVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(hVar, "swanAPI/networkStatusChange");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Network.networkStatusChange")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = hVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, INVOKE, MOVE_EXCEPTION, THROW, THROW, INVOKE, INVOKE, MOVE_EXCEPTION] complete} */
                /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
                @JavascriptInterface
                public String request(String str) {
                    InterceptResult invokeL2;
                    c.a.r0.a.u.e.i.i iVar;
                    String a;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null && (invokeL2 = interceptable2.invokeL(1048580, this, str)) != null) {
                        return (String) invokeL2.objValue;
                    }
                    try {
                        c.a.r0.a.u.g.c.c().a("request");
                        Object obj = this.mApis.get("968563034");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.i.i)) {
                            iVar = (c.a.r0.a.u.e.i.i) obj;
                        } else {
                            iVar = new c.a.r0.a.u.e.i.i(this.mSwanApiContext);
                            this.mApis.put("968563034", iVar);
                        }
                        Pair<Boolean, a> a2 = c.a.r0.a.u.i.a.a(iVar, "swanAPI/request");
                        if (((Boolean) a2.first).booleanValue()) {
                            a = ((a) a2.second).a();
                        } else if (f.a(this.mSwanApiContext.g(), "Network.request")) {
                            a = new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        } else {
                            Pair<a, JSONObject> u = c.a.r0.a.u.c.d.u(str);
                            if (!((a) u.first).isSuccess()) {
                                a = ((a) u.first).a();
                            } else {
                                JSONObject jSONObject = (JSONObject) u.second;
                                if (jSONObject == null) {
                                    a = a.a.a();
                                } else {
                                    c.a.r0.a.u.h.b V = iVar.V(jSONObject);
                                    a = V == null ? "" : V.a();
                                }
                            }
                        }
                        return a;
                    } finally {
                    }
                }
            });
            hashMap.put("_naPayment", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PaymentWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String chooseCoupon(String str) {
                    c.a.r0.a.t1.m.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof c.a.r0.a.t1.m.a)) {
                            aVar = (c.a.r0.a.t1.m.a) obj;
                        } else {
                            aVar = new c.a.r0.a.t1.m.a(this.mSwanApiContext);
                            this.mApis.put("-336396851", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/chooseCoupon");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Payment.chooseCoupon")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = aVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getPaymentInfo(String str) {
                    c.a.r0.a.t1.m.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof c.a.r0.a.t1.m.a)) {
                            aVar = (c.a.r0.a.t1.m.a) obj;
                        } else {
                            aVar = new c.a.r0.a.t1.m.a(this.mSwanApiContext);
                            this.mApis.put("-336396851", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/getPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Payment.getPaymentInfo")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = aVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestThirdPayment(String str) {
                    c.a.r0.a.t1.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1854689529");
                        if (obj != null && (obj instanceof c.a.r0.a.t1.c)) {
                            cVar = (c.a.r0.a.t1.c) obj;
                        } else {
                            cVar = new c.a.r0.a.t1.c(this.mSwanApiContext);
                            this.mApis.put("1854689529", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/requestThirdPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Payment.requestThirdPayment")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = cVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setPaymentInfo(String str) {
                    c.a.r0.a.t1.m.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-336396851");
                        if (obj != null && (obj instanceof c.a.r0.a.t1.m.a)) {
                            aVar = (c.a.r0.a.t1.m.a) obj;
                        } else {
                            aVar = new c.a.r0.a.t1.m.a(this.mSwanApiContext);
                            this.mApis.put("-336396851", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/setPaymentInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Payment.setPaymentInfo")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b z = aVar.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPlugin", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PluginWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String invokePluginChooseAddress(String str) {
                    c.a.r0.a.w1.d.a.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof c.a.r0.a.w1.d.a.a)) {
                            aVar = (c.a.r0.a.w1.d.a.a) obj;
                        } else {
                            aVar = new c.a.r0.a.w1.d.a.a(this.mSwanApiContext);
                            this.mApis.put("-254510461", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/invokePluginChooseAddress");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Plugin.invokePluginChooseAddress")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = aVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginLoginAndGetUserInfo(String str) {
                    c.a.r0.a.w1.d.a.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof c.a.r0.a.w1.d.a.a)) {
                            aVar = (c.a.r0.a.w1.d.a.a) obj;
                        } else {
                            aVar = new c.a.r0.a.w1.d.a.a(this.mSwanApiContext);
                            this.mApis.put("-254510461", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/invokePluginLoginAndGetUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Plugin.invokePluginLoginAndGetUserInfo")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b z = aVar.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String invokePluginPayment(String str) {
                    c.a.r0.a.w1.d.a.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("-254510461");
                        if (obj != null && (obj instanceof c.a.r0.a.w1.d.a.a)) {
                            aVar = (c.a.r0.a.w1.d.a.a) obj;
                        } else {
                            aVar = new c.a.r0.a.w1.d.a.a(this.mSwanApiContext);
                            this.mApis.put("-254510461", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/invokePluginPayment");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Plugin.invokePluginPayment")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = aVar.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrefetch", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrefetchWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String prefetchResources(String str) {
                    c.a.r0.a.h0.o.f.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-2068479848");
                        if (obj != null && (obj instanceof c.a.r0.a.h0.o.f.a)) {
                            aVar = (c.a.r0.a.h0.o.f.a) obj;
                        } else {
                            aVar = new c.a.r0.a.h0.o.f.a(this.mSwanApiContext);
                            this.mApis.put("-2068479848", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/prefetchResources");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Prefetch.prefetchResources")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = aVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPreload", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PreloadWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String preloadStatus(String str) {
                    c.a.r0.a.h0.l.g.o.d.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("423661539");
                        if (obj != null && (obj instanceof c.a.r0.a.h0.l.g.o.d.a)) {
                            aVar = (c.a.r0.a.h0.l.g.o.d.a) obj;
                        } else {
                            aVar = new c.a.r0.a.h0.l.g.o.d.a(this.mSwanApiContext);
                            this.mApis.put("423661539", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/preloadStatus");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Preload.preloadStatus")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = aVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateFile", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateFileWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String uploadFileToBos(String str) {
                    c.a.r0.a.y2.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-1929343869");
                        if (obj != null && (obj instanceof c.a.r0.a.y2.b)) {
                            bVar2 = (c.a.r0.a.y2.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.y2.b(this.mSwanApiContext);
                            this.mApis.put("-1929343869", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/uploadFileToBos");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "PrivateFile.uploadFileToBos")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b C = bVar2.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naRouter", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$RouterWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String hideModalPage() {
                    c.a.r0.a.u.e.j.b bVar2;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.j.b)) {
                            bVar2 = (c.a.r0.a.u.e.j.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.j.b(this.mSwanApiContext);
                            this.mApis.put("-1495163604", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/hideModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Router.hideModalPage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = bVar2.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String navigateBack(String str) {
                    c.a.r0.a.u.e.j.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1495163604");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.j.b)) {
                            bVar2 = (c.a.r0.a.u.e.j.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.j.b(this.mSwanApiContext);
                            this.mApis.put("-1495163604", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/navigateBack");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Router.navigateBack")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b B = bVar2.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String navigateTo(String str) {
                    c.a.r0.a.u.e.j.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.j.c)) {
                            cVar = (c.a.r0.a.u.e.j.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.j.c(this.mSwanApiContext);
                            this.mApis.put("1968522584", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/navigateTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Router.navigateTo")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b H = cVar.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLaunch(String str) {
                    c.a.r0.a.u.e.j.e eVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1317280190");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.j.e)) {
                            eVar = (c.a.r0.a.u.e.j.e) obj;
                        } else {
                            eVar = new c.a.r0.a.u.e.j.e(this.mSwanApiContext);
                            this.mApis.put("1317280190", eVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(eVar, "swanAPI/reLaunch");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Router.reLaunch")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = eVar.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String reLoadErrorPage(String str) {
                    c.a.r0.a.u.e.j.f fVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-420075743");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.j.f)) {
                            fVar = (c.a.r0.a.u.e.j.f) obj;
                        } else {
                            fVar = new c.a.r0.a.u.e.j.f(this.mSwanApiContext);
                            this.mApis.put("-420075743", fVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(fVar, "swanAPI/reLoadErrorPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Router.reLoadErrorPage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = fVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String redirectTo(String str) {
                    c.a.r0.a.u.e.j.d dVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("1792515533");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.j.d)) {
                            dVar = (c.a.r0.a.u.e.j.d) obj;
                        } else {
                            dVar = new c.a.r0.a.u.e.j.d(this.mSwanApiContext);
                            this.mApis.put("1792515533", dVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(dVar, "swanAPI/redirectTo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Router.redirectTo")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b D = dVar.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String showModalPage(String str) {
                    c.a.r0.a.u.e.j.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("1968522584");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.j.c)) {
                            cVar = (c.a.r0.a.u.e.j.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.j.c(this.mSwanApiContext);
                            this.mApis.put("1968522584", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/showModalPage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Router.showModalPage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b J = cVar.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSetting", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$SettingWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String getAppInfoSync() {
                    c.a.r0.a.u.e.k.c cVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.k.c)) {
                            cVar = (c.a.r0.a.u.e.k.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.k.c(this.mSwanApiContext);
                            this.mApis.put("-594895721", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/getAppInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Setting.getAppInfoSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b F = cVar.F();
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSetting(String str) {
                    c.a.r0.a.u.e.k.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.k.c)) {
                            cVar = (c.a.r0.a.u.e.k.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.k.c(this.mSwanApiContext);
                            this.mApis.put("-594895721", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/getSetting");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Setting.getSetting")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b G = cVar.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSlaveIdSync() {
                    c.a.r0.a.u.e.k.c cVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.k.c)) {
                            cVar = (c.a.r0.a.u.e.k.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.k.c(this.mSwanApiContext);
                            this.mApis.put("-594895721", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/getSlaveIdSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Setting.getSlaveIdSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b H = cVar.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSwanId(String str) {
                    c.a.r0.a.u.e.k.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.k.c)) {
                            cVar = (c.a.r0.a.u.e.k.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.k.c(this.mSwanApiContext);
                            this.mApis.put("-594895721", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/getSwanId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Setting.getSwanId")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b I = cVar.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getUserInfo(String str) {
                    c.a.r0.a.u.e.k.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-594895721");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.k.c)) {
                            cVar = (c.a.r0.a.u.e.k.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.k.c(this.mSwanApiContext);
                            this.mApis.put("-594895721", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/getUserInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Setting.getUserInfo")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b J = cVar.J(str);
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String isAllowedAdOpenAppSync() {
                    c.a.r0.a.u.e.k.b bVar2;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("450273045");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.k.b)) {
                            bVar2 = (c.a.r0.a.u.e.k.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.k.b(this.mSwanApiContext);
                            this.mApis.put("450273045", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/isAllowedAdOpenAppSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Setting.isAllowedAdOpenAppSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = bVar2.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naStatisticEvent", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$StatisticEventWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String ubcAndCeresStatisticEvent(String str) {
                    r rVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("712777136");
                        if (obj != null && (obj instanceof r)) {
                            rVar = (r) obj;
                        } else {
                            rVar = new r(this.mSwanApiContext);
                            this.mApis.put("712777136", rVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(rVar, "swanAPI/ubcAndCeresStatisticEvent");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "StatisticEvent.ubcAndCeresStatisticEvent")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = rVar.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naStorage", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$StorageWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String clearGlobalStorage() {
                    c.a.r0.a.u.e.l.c cVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.c)) {
                            cVar = (c.a.r0.a.u.e.l.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.l.c(this.mSwanApiContext);
                            this.mApis.put("-804054859", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/clearGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.clearGlobalStorage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = cVar.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearGlobalStorageSync() {
                    c.a.r0.a.u.e.l.c cVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.c)) {
                            cVar = (c.a.r0.a.u.e.l.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.l.c(this.mSwanApiContext);
                            this.mApis.put("-804054859", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/clearGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.clearGlobalStorageSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b C = cVar.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorage() {
                    c.a.r0.a.u.e.l.b bVar2;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.b)) {
                            bVar2 = (c.a.r0.a.u.e.l.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.l.b(this.mSwanApiContext);
                            this.mApis.put("130910081", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/clearStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.clearStorage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = bVar2.A();
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String clearStorageSync() {
                    c.a.r0.a.u.e.l.b bVar2;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048579, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.b)) {
                            bVar2 = (c.a.r0.a.u.e.l.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.l.b(this.mSwanApiContext);
                            this.mApis.put("130910081", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/clearStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.clearStorageSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b C = bVar2.C();
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorage(String str) {
                    c.a.r0.a.u.e.l.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.c)) {
                            cVar = (c.a.r0.a.u.e.l.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.l.c(this.mSwanApiContext);
                            this.mApis.put("-804054859", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/getGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.getGlobalStorage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b D = cVar.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfo() {
                    c.a.r0.a.u.e.l.c cVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.c)) {
                            cVar = (c.a.r0.a.u.e.l.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.l.c(this.mSwanApiContext);
                            this.mApis.put("-804054859", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/getGlobalStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.getGlobalStorageInfo")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b G = cVar.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageInfoSync() {
                    c.a.r0.a.u.e.l.c cVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.c)) {
                            cVar = (c.a.r0.a.u.e.l.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.l.c(this.mSwanApiContext);
                            this.mApis.put("-804054859", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/getGlobalStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.getGlobalStorageInfoSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b J = cVar.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getGlobalStorageSync(String str) {
                    c.a.r0.a.u.e.l.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.c)) {
                            cVar = (c.a.r0.a.u.e.l.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.l.c(this.mSwanApiContext);
                            this.mApis.put("-804054859", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/getGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.getGlobalStorageSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b K = cVar.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorage(String str) {
                    c.a.r0.a.u.e.l.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.b)) {
                            bVar2 = (c.a.r0.a.u.e.l.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.l.b(this.mSwanApiContext);
                            this.mApis.put("130910081", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/getStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.getStorage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b D = bVar2.D(str);
                        return D == null ? "" : D.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfo() {
                    c.a.r0.a.u.e.l.b bVar2;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048585, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.b)) {
                            bVar2 = (c.a.r0.a.u.e.l.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.l.b(this.mSwanApiContext);
                            this.mApis.put("130910081", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/getStorageInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.getStorageInfo")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b G = bVar2.G();
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoAsync(String str) {
                    c.a.r0.a.u.e.l.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.b)) {
                            bVar2 = (c.a.r0.a.u.e.l.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.l.b(this.mSwanApiContext);
                            this.mApis.put("130910081", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/getStorageInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.getStorageInfoAsync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b H = bVar2.H(str);
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getStorageInfoSync() {
                    c.a.r0.a.u.e.l.b bVar2;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048587, this)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.b)) {
                            bVar2 = (c.a.r0.a.u.e.l.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.l.b(this.mSwanApiContext);
                            this.mApis.put("130910081", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/getStorageInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.getStorageInfoSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b J = bVar2.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getStorageSync(String str) {
                    c.a.r0.a.u.e.l.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.b)) {
                            bVar2 = (c.a.r0.a.u.e.l.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.l.b(this.mSwanApiContext);
                            this.mApis.put("130910081", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/getStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.getStorageSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b K = bVar2.K(str);
                        return K == null ? "" : K.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorage(String str) {
                    c.a.r0.a.u.e.l.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.c)) {
                            cVar = (c.a.r0.a.u.e.l.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.l.c(this.mSwanApiContext);
                            this.mApis.put("-804054859", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/removeGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.removeGlobalStorage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b R = cVar.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeGlobalStorageSync(String str) {
                    c.a.r0.a.u.e.l.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.c)) {
                            cVar = (c.a.r0.a.u.e.l.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.l.c(this.mSwanApiContext);
                            this.mApis.put("-804054859", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/removeGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.removeGlobalStorageSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b T = cVar.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorage(String str) {
                    c.a.r0.a.u.e.l.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.b)) {
                            bVar2 = (c.a.r0.a.u.e.l.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.l.b(this.mSwanApiContext);
                            this.mApis.put("130910081", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/removeStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.removeStorage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b R = bVar2.R(str);
                        return R == null ? "" : R.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String removeStorageSync(String str) {
                    c.a.r0.a.u.e.l.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048592, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.b)) {
                            bVar2 = (c.a.r0.a.u.e.l.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.l.b(this.mSwanApiContext);
                            this.mApis.put("130910081", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/removeStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.removeStorageSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b T = bVar2.T(str);
                        return T == null ? "" : T.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorage(String str) {
                    c.a.r0.a.u.e.l.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048593, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.c)) {
                            cVar = (c.a.r0.a.u.e.l.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.l.c(this.mSwanApiContext);
                            this.mApis.put("-804054859", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/setGlobalStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.setGlobalStorage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b U = cVar.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setGlobalStorageSync(String str) {
                    c.a.r0.a.u.e.l.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048594, this, str)) == null) {
                        Object obj = this.mApis.get("-804054859");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.c)) {
                            cVar = (c.a.r0.a.u.e.l.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.l.c(this.mSwanApiContext);
                            this.mApis.put("-804054859", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/setGlobalStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.setGlobalStorageSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b W = cVar.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorage(String str) {
                    c.a.r0.a.u.e.l.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048595, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.b)) {
                            bVar2 = (c.a.r0.a.u.e.l.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.l.b(this.mSwanApiContext);
                            this.mApis.put("130910081", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/setStorage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.setStorage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b U = bVar2.U(str);
                        return U == null ? "" : U.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setStorageSync(String str) {
                    c.a.r0.a.u.e.l.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048596, this, str)) == null) {
                        Object obj = this.mApis.get("130910081");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.l.b)) {
                            bVar2 = (c.a.r0.a.u.e.l.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.l.b(this.mSwanApiContext);
                            this.mApis.put("130910081", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/setStorageSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Storage.setStorageSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b W = bVar2.W(str);
                        return W == null ? "" : W.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSubscription", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$SubscriptionWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String requestSubscribeFormId(String str) {
                    c.a.r0.a.u.e.m.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("823117982");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.m.b)) {
                            bVar2 = (c.a.r0.a.u.e.m.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.m.b(this.mSwanApiContext);
                            this.mApis.put("823117982", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/subscription/requestSubscribeFormId");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Subscription.requestSubscribeFormId")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b E = bVar2.E(str);
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String subscribeService(String str) {
                    c.a.r0.a.u.e.m.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-947445811");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.m.c)) {
                            cVar = (c.a.r0.a.u.e.m.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.m.c(this.mSwanApiContext);
                            this.mApis.put("-947445811", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/subscribeService");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Subscription.subscribeService")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b F = cVar.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naSystem", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$SystemWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String exitFullScreen(String str) {
                    c.a.r0.a.u.e.n.g gVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1936205521");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.n.g)) {
                            gVar = (c.a.r0.a.u.e.n.g) obj;
                        } else {
                            gVar = new c.a.r0.a.u.e.n.g(this.mSwanApiContext);
                            this.mApis.put("1936205521", gVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(gVar, "swanAPI/exitFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.exitFullScreen")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = gVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getBrightness() {
                    c.a.r0.a.u.e.n.c cVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                        Object obj = this.mApis.get("99997465");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.n.c)) {
                            cVar = (c.a.r0.a.u.e.n.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.n.c(this.mSwanApiContext);
                            this.mApis.put("99997465", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/getBrightness");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.getBrightness")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = cVar.y();
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getClipboardData() {
                    c.a.r0.a.u.e.n.d dVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.n.d)) {
                            dVar = (c.a.r0.a.u.e.n.d) obj;
                        } else {
                            dVar = new c.a.r0.a.u.e.n.d(this.mSwanApiContext);
                            this.mApis.put("-518757484", dVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(dVar, "swanAPI/getClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.getClipboardData")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = dVar.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getDeviceInfo(String str) {
                    c.a.r0.a.u.e.n.f fVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1694151270");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.n.f)) {
                            fVar = (c.a.r0.a.u.e.n.f) obj;
                        } else {
                            fVar = new c.a.r0.a.u.e.n.f(this.mSwanApiContext);
                            this.mApis.put("1694151270", fVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(fVar, "swanAPI/getDeviceInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.getDeviceInfo")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = fVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getDeviceProfile(String str) {
                    c.a.r0.a.u.e.n.h hVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("-1321681619");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.n.h)) {
                            hVar = (c.a.r0.a.u.e.n.h) obj;
                        } else {
                            hVar = new c.a.r0.a.u.e.n.h(this.mSwanApiContext);
                            this.mApis.put("-1321681619", hVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(hVar, "swanAPI/getDeviceProfile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.getDeviceProfile")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = hVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getMediaVolume() {
                    n nVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048581, this)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof n)) {
                            nVar = (n) obj;
                        } else {
                            nVar = new n(this.mSwanApiContext);
                            this.mApis.put("447234992", nVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(nVar, "swanAPI/getMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.getMediaVolume")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = nVar.x();
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String makePhoneCall(String str) {
                    c.a.r0.a.u.e.n.i iVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048582, this, str)) == null) {
                        Object obj = this.mApis.get("-1569246082");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.n.i)) {
                            iVar = (c.a.r0.a.u.e.n.i) obj;
                        } else {
                            iVar = new c.a.r0.a.u.e.n.i(this.mSwanApiContext);
                            this.mApis.put("-1569246082", iVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(iVar, "swanAPI/makePhoneCall");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.makePhoneCall")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = iVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String openSMSPanel(String str) {
                    k kVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("1099851202");
                        if (obj != null && (obj instanceof k)) {
                            kVar = (k) obj;
                        } else {
                            kVar = new k(this.mSwanApiContext);
                            this.mApis.put("1099851202", kVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(kVar, "swanAPI/openSMSPanel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.openSMSPanel")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = kVar.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String requestFullScreen(String str) {
                    c.a.r0.a.u.e.n.j jVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
                        Object obj = this.mApis.get("-1707203360");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.n.j)) {
                            jVar = (c.a.r0.a.u.e.n.j) obj;
                        } else {
                            jVar = new c.a.r0.a.u.e.n.j(this.mSwanApiContext);
                            this.mApis.put("-1707203360", jVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(jVar, "swanAPI/requestFullScreen");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.requestFullScreen")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b F = jVar.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setClipboardData(String str) {
                    c.a.r0.a.u.e.n.d dVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-518757484");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.n.d)) {
                            dVar = (c.a.r0.a.u.e.n.d) obj;
                        } else {
                            dVar = new c.a.r0.a.u.e.n.d(this.mSwanApiContext);
                            this.mApis.put("-518757484", dVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(dVar, "swanAPI/setClipboardData");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.setClipboardData")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = dVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setErrorPageType(String str) {
                    c.a.r0.a.k1.d dVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("1161486049");
                        if (obj != null && (obj instanceof c.a.r0.a.k1.d)) {
                            dVar = (c.a.r0.a.k1.d) obj;
                        } else {
                            dVar = new c.a.r0.a.k1.d(this.mSwanApiContext);
                            this.mApis.put("1161486049", dVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(dVar, "swanAPI/setErrorPageType");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.setErrorPageType")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = dVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String setMediaVolume(String str) {
                    n nVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("447234992");
                        if (obj != null && (obj instanceof n)) {
                            nVar = (n) obj;
                        } else {
                            nVar = new n(this.mSwanApiContext);
                            this.mApis.put("447234992", nVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(nVar, "swanAPI/setMediaVolume");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.setMediaVolume")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b z = nVar.z(str);
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startAccelerometer(String str) {
                    c.a.r0.a.u.e.n.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.n.b)) {
                            bVar2 = (c.a.r0.a.u.e.n.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.n.b(this.mSwanApiContext);
                            this.mApis.put("1372680763", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/startAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.startAccelerometer")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = bVar2.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startCompass(String str) {
                    c.a.r0.a.u.e.n.e eVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.n.e)) {
                            eVar = (c.a.r0.a.u.e.n.e) obj;
                        } else {
                            eVar = new c.a.r0.a.u.e.n.e(this.mSwanApiContext);
                            this.mApis.put("1689255576", eVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(eVar, "swanAPI/startCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.startCompass")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = eVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopAccelerometer() {
                    c.a.r0.a.u.e.n.b bVar2;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048590, this)) == null) {
                        Object obj = this.mApis.get("1372680763");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.n.b)) {
                            bVar2 = (c.a.r0.a.u.e.n.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.n.b(this.mSwanApiContext);
                            this.mApis.put("1372680763", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/stopAccelerometer");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.stopAccelerometer")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b B = bVar2.B();
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String stopCompass() {
                    c.a.r0.a.u.e.n.e eVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048591, this)) == null) {
                        Object obj = this.mApis.get("1689255576");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.n.e)) {
                            eVar = (c.a.r0.a.u.e.n.e) obj;
                        } else {
                            eVar = new c.a.r0.a.u.e.n.e(this.mSwanApiContext);
                            this.mApis.put("1689255576", eVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(eVar, "swanAPI/stopCompass");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "System.stopCompass")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b z = eVar.z();
                        return z == null ? "" : z.a();
                    }
                    return (String) invokeV.objValue;
                }
            });
            hashMap.put("_naUtils", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$UtilsWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String addToDesktop(String str) {
                    c.a.r0.a.u.e.p.f fVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("201194468");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.p.f)) {
                            fVar = (c.a.r0.a.u.e.p.f) obj;
                        } else {
                            fVar = new c.a.r0.a.u.e.p.f(this.mSwanApiContext);
                            this.mApis.put("201194468", fVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(fVar, "swanAPI/addToDesktop");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.addToDesktop")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b B = fVar.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String calcMD5(String str) {
                    c.a.r0.a.u.e.p.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("-1412306947");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.p.b)) {
                            bVar2 = (c.a.r0.a.u.e.p.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.u.e.p.b(this.mSwanApiContext);
                            this.mApis.put("-1412306947", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/calcMD5");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.calcMD5")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = bVar2.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String checkAppInstalled(String str) {
                    c.a.r0.a.u.e.p.c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1626415364");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.p.c)) {
                            cVar = (c.a.r0.a.u.e.p.c) obj;
                        } else {
                            cVar = new c.a.r0.a.u.e.p.c(this.mSwanApiContext);
                            this.mApis.put("1626415364", cVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(cVar, "swanAPI/checkAppInstalled");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.checkAppInstalled")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = cVar.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    c.a.r0.a.u.e.p.e eVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("-836768778");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.p.e)) {
                            eVar = (c.a.r0.a.u.e.p.e) obj;
                        } else {
                            eVar = new c.a.r0.a.u.e.p.e(this.mSwanApiContext);
                            this.mApis.put("-836768778", eVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(eVar, "swanAPI/getCommonSysInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.getCommonSysInfo")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = eVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getCommonSysInfoSync() {
                    c.a.r0.a.u.e.p.k kVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048580, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.p.k)) {
                            kVar = (c.a.r0.a.u.e.p.k) obj;
                        } else {
                            kVar = new c.a.r0.a.u.e.p.k(this.mSwanApiContext);
                            this.mApis.put("-1011537871", kVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(kVar, "swanAPI/getCommonSysInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.getCommonSysInfoSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b E = kVar.E();
                        return E == null ? "" : E.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getPerformanceLevel(String str) {
                    c.a.r0.a.u.e.p.g gVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048581, this, str)) == null) {
                        Object obj = this.mApis.get("-810858308");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.p.g)) {
                            gVar = (c.a.r0.a.u.e.p.g) obj;
                        } else {
                            gVar = new c.a.r0.a.u.e.p.g(this.mSwanApiContext);
                            this.mApis.put("-810858308", gVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(gVar, "swanAPI/getPerformanceLevel");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.getPerformanceLevel")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = gVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfo() {
                    c.a.r0.a.u.e.p.k kVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048582, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.p.k)) {
                            kVar = (c.a.r0.a.u.e.p.k) obj;
                        } else {
                            kVar = new c.a.r0.a.u.e.p.k(this.mSwanApiContext);
                            this.mApis.put("-1011537871", kVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(kVar, "swanAPI/getSystemInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.getSystemInfo")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b H = kVar.H();
                        return H == null ? "" : H.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoAsync(String str) {
                    c.a.r0.a.u.e.p.k kVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048583, this, str)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.p.k)) {
                            kVar = (c.a.r0.a.u.e.p.k) obj;
                        } else {
                            kVar = new c.a.r0.a.u.e.p.k(this.mSwanApiContext);
                            this.mApis.put("-1011537871", kVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(kVar, "swanAPI/getSystemInfoAsync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.getSystemInfoAsync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b I = kVar.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getSystemInfoSync() {
                    c.a.r0.a.u.e.p.k kVar;
                    InterceptResult invokeV;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeV = interceptable2.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                        Object obj = this.mApis.get("-1011537871");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.p.k)) {
                            kVar = (c.a.r0.a.u.e.p.k) obj;
                        } else {
                            kVar = new c.a.r0.a.u.e.p.k(this.mSwanApiContext);
                            this.mApis.put("-1011537871", kVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(kVar, "swanAPI/getSystemInfoSync");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.getSystemInfoSync")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b J = kVar.J();
                        return J == null ? "" : J.a();
                    }
                    return (String) invokeV.objValue;
                }

                @JavascriptInterface
                public String handleException(String str) {
                    c.a.r0.a.u.e.p.h hVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048585, this, str)) == null) {
                        Object obj = this.mApis.get("-2097727681");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.p.h)) {
                            hVar = (c.a.r0.a.u.e.p.h) obj;
                        } else {
                            hVar = new c.a.r0.a.u.e.p.h(this.mSwanApiContext);
                            this.mApis.put("-2097727681", hVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(hVar, "swanAPI/handleException");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.handleException")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = hVar.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hasCloseHandler(String str) {
                    c.a.r0.a.u.e.p.d dVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048586, this, str)) == null) {
                        Object obj = this.mApis.get("2084449317");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.p.d)) {
                            dVar = (c.a.r0.a.u.e.p.d) obj;
                        } else {
                            dVar = new c.a.r0.a.u.e.p.d(this.mSwanApiContext);
                            this.mApis.put("2084449317", dVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(dVar, "swanAPI/hasCloseHandler");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.hasCloseHandler")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = dVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String hideCaptureScreenShareDialog(String str) {
                    c.a.r0.a.g2.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048587, this, str)) == null) {
                        Object obj = this.mApis.get("1031678042");
                        if (obj != null && (obj instanceof c.a.r0.a.g2.b)) {
                            bVar2 = (c.a.r0.a.g2.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.g2.b(this.mSwanApiContext);
                            this.mApis.put("1031678042", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/hideCaptureScreenShareDialog");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.hideCaptureScreenShareDialog")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b x = bVar2.x(str);
                        return x == null ? "" : x.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String logToFile(String str) {
                    c.a.r0.a.u.e.p.i iVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048588, this, str)) == null) {
                        Object obj = this.mApis.get("1751900130");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.p.i)) {
                            iVar = (c.a.r0.a.u.e.p.i) obj;
                        } else {
                            iVar = new c.a.r0.a.u.e.p.i(this.mSwanApiContext);
                            this.mApis.put("1751900130", iVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(iVar, "swanAPI/logToFile");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.logToFile")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b y = iVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String preloadPackage(String str) {
                    c.a.r0.a.f2.f.m0.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048589, this, str)) == null) {
                        Object obj = this.mApis.get("1748196865");
                        if (obj != null && (obj instanceof c.a.r0.a.f2.f.m0.b)) {
                            bVar2 = (c.a.r0.a.f2.f.m0.b) obj;
                        } else {
                            bVar2 = new c.a.r0.a.f2.f.m0.b(this.mSwanApiContext);
                            this.mApis.put("1748196865", bVar2);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(bVar2, "swanAPI/preloadPackage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.preloadPackage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = bVar2.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String previewImage(String str) {
                    c.a.r0.a.u.e.p.j jVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048590, this, str)) == null) {
                        Object obj = this.mApis.get("589529211");
                        if (obj != null && (obj instanceof c.a.r0.a.u.e.p.j)) {
                            jVar = (c.a.r0.a.u.e.p.j) obj;
                        } else {
                            jVar = new c.a.r0.a.u.e.p.j(this.mSwanApiContext);
                            this.mApis.put("589529211", jVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(jVar, "swanAPI/previewImage");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.previewImage")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b B = jVar.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String ubcFlowJar(String str) {
                    m mVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048591, this, str)) == null) {
                        Object obj = this.mApis.get("-577481801");
                        if (obj != null && (obj instanceof m)) {
                            mVar = (m) obj;
                        } else {
                            mVar = new m(this.mSwanApiContext);
                            this.mApis.put("-577481801", mVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(mVar, "swanAPI/ubcFlowJar");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Utils.ubcFlowJar")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b I = mVar.I(str);
                        return I == null ? "" : I.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naWifi", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$WifiWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String connectWifi(String str) {
                    c.a.r0.a.r2.l.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof c.a.r0.a.r2.l.a)) {
                            aVar = (c.a.r0.a.r2.l.a) obj;
                        } else {
                            aVar = new c.a.r0.a.r2.l.a(this.mSwanApiContext);
                            this.mApis.put("1879401452", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/connectWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Wifi.connectWifi")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b A = aVar.A(str);
                        return A == null ? "" : A.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getConnectedWifi(String str) {
                    c.a.r0.a.r2.l.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof c.a.r0.a.r2.l.a)) {
                            aVar = (c.a.r0.a.r2.l.a) obj;
                        } else {
                            aVar = new c.a.r0.a.r2.l.a(this.mSwanApiContext);
                            this.mApis.put("1879401452", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/getConnectedWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Wifi.getConnectedWifi")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b B = aVar.B(str);
                        return B == null ? "" : B.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String getWifiList(String str) {
                    c.a.r0.a.r2.l.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof c.a.r0.a.r2.l.a)) {
                            aVar = (c.a.r0.a.r2.l.a) obj;
                        } else {
                            aVar = new c.a.r0.a.r2.l.a(this.mSwanApiContext);
                            this.mApis.put("1879401452", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/getWifiList");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Wifi.getWifiList")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b C = aVar.C(str);
                        return C == null ? "" : C.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String startWifi(String str) {
                    c.a.r0.a.r2.l.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048579, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof c.a.r0.a.r2.l.a)) {
                            aVar = (c.a.r0.a.r2.l.a) obj;
                        } else {
                            aVar = new c.a.r0.a.r2.l.a(this.mSwanApiContext);
                            this.mApis.put("1879401452", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/startWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Wifi.startWifi")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b G = aVar.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String stopWifi(String str) {
                    c.a.r0.a.r2.l.a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048580, this, str)) == null) {
                        Object obj = this.mApis.get("1879401452");
                        if (obj != null && (obj instanceof c.a.r0.a.r2.l.a)) {
                            aVar = (c.a.r0.a.r2.l.a) obj;
                        } else {
                            aVar = new c.a.r0.a.r2.l.a(this.mSwanApiContext);
                            this.mApis.put("1879401452", aVar);
                        }
                        Pair<Boolean, a> a = c.a.r0.a.u.i.a.a(aVar, "swanAPI/stopWifi");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.g(), "Wifi.stopWifi")) {
                            return new c.a.r0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.r0.a.u.h.b H = aVar.H(str);
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
