package com.baidu.swan.bdprivate.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.is1;
import com.repackage.js1;
import com.repackage.ko1;
import com.repackage.ks1;
import com.repackage.ph3;
import com.repackage.q22;
import com.repackage.qh3;
import com.repackage.rh3;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
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
            hashMap.put("_naPrivateAccount", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
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
                public String getBDUSS(String str) {
                    ph3 ph3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("446653951");
                        if (obj != null && (obj instanceof ph3)) {
                            ph3Var = (ph3) obj;
                        } else {
                            ph3Var = new ph3(this.mSwanApiContext);
                            this.mApis.put("446653951", ph3Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(ph3Var, "swanAPI/getBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "PrivateAccount.getBDUSS")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = ph3Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateBusiness", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
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
                public String getOpenBDUSS(String str) {
                    qh3 qh3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-404108695");
                        if (obj != null && (obj instanceof qh3)) {
                            qh3Var = (qh3) obj;
                        } else {
                            qh3Var = new qh3(this.mSwanApiContext);
                            this.mApis.put("-404108695", qh3Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(qh3Var, "swanAPI/getOpenBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "PrivateBusiness.getOpenBDUSS")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = qh3Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryQuickLoginInfo(String str) {
                    rh3 rh3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof rh3)) {
                            rh3Var = (rh3) obj;
                        } else {
                            rh3Var = new rh3(this.mSwanApiContext);
                            this.mApis.put("1495818240", rh3Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(rh3Var, "swanAPI/queryQuickLoginInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "PrivateBusiness.queryQuickLoginInfo")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 F = rh3Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String quickLogin(String str) {
                    rh3 rh3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof rh3)) {
                            rh3Var = (rh3) obj;
                        } else {
                            rh3Var = new rh3(this.mSwanApiContext);
                            this.mApis.put("1495818240", rh3Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(rh3Var, "swanAPI/quickLogin");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "PrivateBusiness.quickLogin")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 G = rh3Var.G(str);
                        return G == null ? "" : G.a();
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
            hashMap.put("_naPrivateAccount", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
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
                public String getBDUSS(String str) {
                    ph3 ph3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("446653951");
                        if (obj != null && (obj instanceof ph3)) {
                            ph3Var = (ph3) obj;
                        } else {
                            ph3Var = new ph3(this.mSwanApiContext);
                            this.mApis.put("446653951", ph3Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(ph3Var, "swanAPI/getBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "PrivateAccount.getBDUSS")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = ph3Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateBusiness", new Object(ko1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
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
                public String getOpenBDUSS(String str) {
                    qh3 qh3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-404108695");
                        if (obj != null && (obj instanceof qh3)) {
                            qh3Var = (qh3) obj;
                        } else {
                            qh3Var = new qh3(this.mSwanApiContext);
                            this.mApis.put("-404108695", qh3Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(qh3Var, "swanAPI/getOpenBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "PrivateBusiness.getOpenBDUSS")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 y = qh3Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryQuickLoginInfo(String str) {
                    rh3 rh3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof rh3)) {
                            rh3Var = (rh3) obj;
                        } else {
                            rh3Var = new rh3(this.mSwanApiContext);
                            this.mApis.put("1495818240", rh3Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(rh3Var, "swanAPI/queryQuickLoginInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "PrivateBusiness.queryQuickLoginInfo")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 F = rh3Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String quickLogin(String str) {
                    rh3 rh3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof rh3)) {
                            rh3Var = (rh3) obj;
                        } else {
                            rh3Var = new rh3(this.mSwanApiContext);
                            this.mApis.put("1495818240", rh3Var);
                        }
                        Pair<Boolean, is1> a = ks1.a(rh3Var, "swanAPI/quickLogin");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((is1) a.second).a();
                        }
                        if (q22.a(this.mSwanApiContext.h(), "PrivateBusiness.quickLogin")) {
                            return new js1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        js1 G = rh3Var.G(str);
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
