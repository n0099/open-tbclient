package com.baidu.swan.bdprivate.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import c.a.n0.a.k.c.b;
import c.a.n0.a.x.l.g.f;
import c.a.n0.b.e.a;
import c.a.n0.b.e.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes4.dex */
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

    public static Map<String, Object> getV8ApiModules(final b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naPrivateAccount", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String getBDUSS(String str) {
                    a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("446653951");
                        if (obj != null && (obj instanceof a)) {
                            aVar = (a) obj;
                        } else {
                            aVar = new a(this.mSwanApiContext);
                            this.mApis.put("446653951", aVar);
                        }
                        Pair<Boolean, c.a.n0.a.k.h.a> a = c.a.n0.a.k.i.a.a(aVar, "swanAPI/getBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((c.a.n0.a.k.h.a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.h(), "PrivateAccount.getBDUSS")) {
                            return new c.a.n0.a.k.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.n0.a.k.h.b y = aVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateBusiness", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String getOpenBDUSS(String str) {
                    c.a.n0.b.e.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-404108695");
                        if (obj != null && (obj instanceof c.a.n0.b.e.b)) {
                            bVar2 = (c.a.n0.b.e.b) obj;
                        } else {
                            bVar2 = new c.a.n0.b.e.b(this.mSwanApiContext);
                            this.mApis.put("-404108695", bVar2);
                        }
                        Pair<Boolean, c.a.n0.a.k.h.a> a = c.a.n0.a.k.i.a.a(bVar2, "swanAPI/getOpenBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((c.a.n0.a.k.h.a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.h(), "PrivateBusiness.getOpenBDUSS")) {
                            return new c.a.n0.a.k.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.n0.a.k.h.b y = bVar2.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryQuickLoginInfo(String str) {
                    c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof c)) {
                            cVar = (c) obj;
                        } else {
                            cVar = new c(this.mSwanApiContext);
                            this.mApis.put("1495818240", cVar);
                        }
                        Pair<Boolean, c.a.n0.a.k.h.a> a = c.a.n0.a.k.i.a.a(cVar, "swanAPI/queryQuickLoginInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((c.a.n0.a.k.h.a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.h(), "PrivateBusiness.queryQuickLoginInfo")) {
                            return new c.a.n0.a.k.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.n0.a.k.h.b F = cVar.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String quickLogin(String str) {
                    c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof c)) {
                            cVar = (c) obj;
                        } else {
                            cVar = new c(this.mSwanApiContext);
                            this.mApis.put("1495818240", cVar);
                        }
                        Pair<Boolean, c.a.n0.a.k.h.a> a = c.a.n0.a.k.i.a.a(cVar, "swanAPI/quickLogin");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((c.a.n0.a.k.h.a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.h(), "PrivateBusiness.quickLogin")) {
                            return new c.a.n0.a.k.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.n0.a.k.h.b G = cVar.G(str);
                        return G == null ? "" : G.a();
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
            hashMap.put("_naPrivateAccount", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String getBDUSS(String str) {
                    a aVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("446653951");
                        if (obj != null && (obj instanceof a)) {
                            aVar = (a) obj;
                        } else {
                            aVar = new a(this.mSwanApiContext);
                            this.mApis.put("446653951", aVar);
                        }
                        Pair<Boolean, c.a.n0.a.k.h.a> a = c.a.n0.a.k.i.a.a(aVar, "swanAPI/getBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((c.a.n0.a.k.h.a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.h(), "PrivateAccount.getBDUSS")) {
                            return new c.a.n0.a.k.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.n0.a.k.h.b y = aVar.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateBusiness", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
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
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String getOpenBDUSS(String str) {
                    c.a.n0.b.e.b bVar2;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-404108695");
                        if (obj != null && (obj instanceof c.a.n0.b.e.b)) {
                            bVar2 = (c.a.n0.b.e.b) obj;
                        } else {
                            bVar2 = new c.a.n0.b.e.b(this.mSwanApiContext);
                            this.mApis.put("-404108695", bVar2);
                        }
                        Pair<Boolean, c.a.n0.a.k.h.a> a = c.a.n0.a.k.i.a.a(bVar2, "swanAPI/getOpenBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((c.a.n0.a.k.h.a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.h(), "PrivateBusiness.getOpenBDUSS")) {
                            return new c.a.n0.a.k.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.n0.a.k.h.b y = bVar2.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryQuickLoginInfo(String str) {
                    c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof c)) {
                            cVar = (c) obj;
                        } else {
                            cVar = new c(this.mSwanApiContext);
                            this.mApis.put("1495818240", cVar);
                        }
                        Pair<Boolean, c.a.n0.a.k.h.a> a = c.a.n0.a.k.i.a.a(cVar, "swanAPI/queryQuickLoginInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((c.a.n0.a.k.h.a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.h(), "PrivateBusiness.queryQuickLoginInfo")) {
                            return new c.a.n0.a.k.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.n0.a.k.h.b F = cVar.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String quickLogin(String str) {
                    c cVar;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof c)) {
                            cVar = (c) obj;
                        } else {
                            cVar = new c(this.mSwanApiContext);
                            this.mApis.put("1495818240", cVar);
                        }
                        Pair<Boolean, c.a.n0.a.k.h.a> a = c.a.n0.a.k.i.a.a(cVar, "swanAPI/quickLogin");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((c.a.n0.a.k.h.a) a.second).a();
                        }
                        if (f.a(this.mSwanApiContext.h(), "PrivateBusiness.quickLogin")) {
                            return new c.a.n0.a.k.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        c.a.n0.a.k.h.b G = cVar.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}
