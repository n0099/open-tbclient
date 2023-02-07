package com.baidu.swan.bdprivate.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.db2;
import com.baidu.tieba.dq3;
import com.baidu.tieba.eq3;
import com.baidu.tieba.fq3;
import com.baidu.tieba.v02;
import com.baidu.tieba.w02;
import com.baidu.tieba.x02;
import com.baidu.tieba.xw1;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
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
            hashMap.put("_naPrivateAccount", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
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
                public String getBDUSS(String str) {
                    dq3 dq3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("446653951");
                        if (obj != null && (obj instanceof dq3)) {
                            dq3Var = (dq3) obj;
                        } else {
                            dq3Var = new dq3(this.mSwanApiContext);
                            this.mApis.put("446653951", dq3Var);
                        }
                        Pair<Boolean, v02> a = x02.a(dq3Var, "swanAPI/getBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "PrivateAccount.getBDUSS")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = dq3Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateBusiness", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
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
                public String getOpenBDUSS(String str) {
                    eq3 eq3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-404108695");
                        if (obj != null && (obj instanceof eq3)) {
                            eq3Var = (eq3) obj;
                        } else {
                            eq3Var = new eq3(this.mSwanApiContext);
                            this.mApis.put("-404108695", eq3Var);
                        }
                        Pair<Boolean, v02> a = x02.a(eq3Var, "swanAPI/getOpenBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "PrivateBusiness.getOpenBDUSS")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = eq3Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryQuickLoginInfo(String str) {
                    fq3 fq3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof fq3)) {
                            fq3Var = (fq3) obj;
                        } else {
                            fq3Var = new fq3(this.mSwanApiContext);
                            this.mApis.put("1495818240", fq3Var);
                        }
                        Pair<Boolean, v02> a = x02.a(fq3Var, "swanAPI/queryQuickLoginInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "PrivateBusiness.queryQuickLoginInfo")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 F = fq3Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String quickLogin(String str) {
                    fq3 fq3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof fq3)) {
                            fq3Var = (fq3) obj;
                        } else {
                            fq3Var = new fq3(this.mSwanApiContext);
                            this.mApis.put("1495818240", fq3Var);
                        }
                        Pair<Boolean, v02> a = x02.a(fq3Var, "swanAPI/quickLogin");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "PrivateBusiness.quickLogin")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 G = fq3Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
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
            hashMap.put("_naPrivateAccount", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
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
                public String getBDUSS(String str) {
                    dq3 dq3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("446653951");
                        if (obj != null && (obj instanceof dq3)) {
                            dq3Var = (dq3) obj;
                        } else {
                            dq3Var = new dq3(this.mSwanApiContext);
                            this.mApis.put("446653951", dq3Var);
                        }
                        Pair<Boolean, v02> a = x02.a(dq3Var, "swanAPI/getBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "PrivateAccount.getBDUSS")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = dq3Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateBusiness", new Object(xw1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
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
                public String getOpenBDUSS(String str) {
                    eq3 eq3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-404108695");
                        if (obj != null && (obj instanceof eq3)) {
                            eq3Var = (eq3) obj;
                        } else {
                            eq3Var = new eq3(this.mSwanApiContext);
                            this.mApis.put("-404108695", eq3Var);
                        }
                        Pair<Boolean, v02> a = x02.a(eq3Var, "swanAPI/getOpenBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "PrivateBusiness.getOpenBDUSS")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 y = eq3Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryQuickLoginInfo(String str) {
                    fq3 fq3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof fq3)) {
                            fq3Var = (fq3) obj;
                        } else {
                            fq3Var = new fq3(this.mSwanApiContext);
                            this.mApis.put("1495818240", fq3Var);
                        }
                        Pair<Boolean, v02> a = x02.a(fq3Var, "swanAPI/queryQuickLoginInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "PrivateBusiness.queryQuickLoginInfo")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 F = fq3Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String quickLogin(String str) {
                    fq3 fq3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof fq3)) {
                            fq3Var = (fq3) obj;
                        } else {
                            fq3Var = new fq3(this.mSwanApiContext);
                            this.mApis.put("1495818240", fq3Var);
                        }
                        Pair<Boolean, v02> a = x02.a(fq3Var, "swanAPI/quickLogin");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((v02) a.second).a();
                        }
                        if (db2.a(this.mSwanApiContext.f(), "PrivateBusiness.quickLogin")) {
                            return new w02(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        w02 G = fq3Var.G(str);
                        if (G == null) {
                            return "";
                        }
                        return G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}
