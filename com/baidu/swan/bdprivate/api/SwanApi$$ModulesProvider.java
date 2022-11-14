package com.baidu.swan.bdprivate.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.ew1;
import com.baidu.tieba.fw1;
import com.baidu.tieba.gs1;
import com.baidu.tieba.gw1;
import com.baidu.tieba.m62;
import com.baidu.tieba.ml3;
import com.baidu.tieba.nl3;
import com.baidu.tieba.ol3;
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

    public static Map<String, Object> getV8ApiModules(final gs1 gs1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, gs1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naPrivateAccount", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String getBDUSS(String str) {
                    ml3 ml3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("446653951");
                        if (obj != null && (obj instanceof ml3)) {
                            ml3Var = (ml3) obj;
                        } else {
                            ml3Var = new ml3(this.mSwanApiContext);
                            this.mApis.put("446653951", ml3Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ml3Var, "swanAPI/getBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "PrivateAccount.getBDUSS")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = ml3Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateBusiness", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String getOpenBDUSS(String str) {
                    nl3 nl3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-404108695");
                        if (obj != null && (obj instanceof nl3)) {
                            nl3Var = (nl3) obj;
                        } else {
                            nl3Var = new nl3(this.mSwanApiContext);
                            this.mApis.put("-404108695", nl3Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(nl3Var, "swanAPI/getOpenBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "PrivateBusiness.getOpenBDUSS")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = nl3Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryQuickLoginInfo(String str) {
                    ol3 ol3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof ol3)) {
                            ol3Var = (ol3) obj;
                        } else {
                            ol3Var = new ol3(this.mSwanApiContext);
                            this.mApis.put("1495818240", ol3Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ol3Var, "swanAPI/queryQuickLoginInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "PrivateBusiness.queryQuickLoginInfo")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 F = ol3Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String quickLogin(String str) {
                    ol3 ol3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof ol3)) {
                            ol3Var = (ol3) obj;
                        } else {
                            ol3Var = new ol3(this.mSwanApiContext);
                            this.mApis.put("1495818240", ol3Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ol3Var, "swanAPI/quickLogin");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "PrivateBusiness.quickLogin")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 G = ol3Var.G(str);
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

    public static Map<String, Object> getWebviewApiModules(final gs1 gs1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, gs1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naPrivateAccount", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String getBDUSS(String str) {
                    ml3 ml3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("446653951");
                        if (obj != null && (obj instanceof ml3)) {
                            ml3Var = (ml3) obj;
                        } else {
                            ml3Var = new ml3(this.mSwanApiContext);
                            this.mApis.put("446653951", ml3Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ml3Var, "swanAPI/getBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "PrivateAccount.getBDUSS")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = ml3Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateBusiness", new Object(gs1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public gs1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {gs1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = gs1Var;
                }

                @JavascriptInterface
                public String getOpenBDUSS(String str) {
                    nl3 nl3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-404108695");
                        if (obj != null && (obj instanceof nl3)) {
                            nl3Var = (nl3) obj;
                        } else {
                            nl3Var = new nl3(this.mSwanApiContext);
                            this.mApis.put("-404108695", nl3Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(nl3Var, "swanAPI/getOpenBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "PrivateBusiness.getOpenBDUSS")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 y = nl3Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryQuickLoginInfo(String str) {
                    ol3 ol3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof ol3)) {
                            ol3Var = (ol3) obj;
                        } else {
                            ol3Var = new ol3(this.mSwanApiContext);
                            this.mApis.put("1495818240", ol3Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ol3Var, "swanAPI/queryQuickLoginInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "PrivateBusiness.queryQuickLoginInfo")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 F = ol3Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String quickLogin(String str) {
                    ol3 ol3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof ol3)) {
                            ol3Var = (ol3) obj;
                        } else {
                            ol3Var = new ol3(this.mSwanApiContext);
                            this.mApis.put("1495818240", ol3Var);
                        }
                        Pair<Boolean, ew1> a = gw1.a(ol3Var, "swanAPI/quickLogin");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ew1) a.second).a();
                        }
                        if (m62.a(this.mSwanApiContext.f(), "PrivateBusiness.quickLogin")) {
                            return new fw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        fw1 G = ol3Var.G(str);
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
