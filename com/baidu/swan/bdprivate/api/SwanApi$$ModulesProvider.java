package com.baidu.swan.bdprivate.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.f52;
import com.baidu.tieba.fk3;
import com.baidu.tieba.gk3;
import com.baidu.tieba.hk3;
import com.baidu.tieba.xu1;
import com.baidu.tieba.yu1;
import com.baidu.tieba.zq1;
import com.baidu.tieba.zu1;
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

    public static Map<String, Object> getV8ApiModules(final zq1 zq1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, zq1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naPrivateAccount", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
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
                public String getBDUSS(String str) {
                    fk3 fk3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("446653951");
                        if (obj != null && (obj instanceof fk3)) {
                            fk3Var = (fk3) obj;
                        } else {
                            fk3Var = new fk3(this.mSwanApiContext);
                            this.mApis.put("446653951", fk3Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(fk3Var, "swanAPI/getBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "PrivateAccount.getBDUSS")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = fk3Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateBusiness", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
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
                public String getOpenBDUSS(String str) {
                    gk3 gk3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-404108695");
                        if (obj != null && (obj instanceof gk3)) {
                            gk3Var = (gk3) obj;
                        } else {
                            gk3Var = new gk3(this.mSwanApiContext);
                            this.mApis.put("-404108695", gk3Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(gk3Var, "swanAPI/getOpenBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "PrivateBusiness.getOpenBDUSS")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = gk3Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryQuickLoginInfo(String str) {
                    hk3 hk3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof hk3)) {
                            hk3Var = (hk3) obj;
                        } else {
                            hk3Var = new hk3(this.mSwanApiContext);
                            this.mApis.put("1495818240", hk3Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(hk3Var, "swanAPI/queryQuickLoginInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "PrivateBusiness.queryQuickLoginInfo")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 F = hk3Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String quickLogin(String str) {
                    hk3 hk3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof hk3)) {
                            hk3Var = (hk3) obj;
                        } else {
                            hk3Var = new hk3(this.mSwanApiContext);
                            this.mApis.put("1495818240", hk3Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(hk3Var, "swanAPI/quickLogin");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "PrivateBusiness.quickLogin")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 G = hk3Var.G(str);
                        return G == null ? "" : G.a();
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
            hashMap.put("_naPrivateAccount", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
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
                public String getBDUSS(String str) {
                    fk3 fk3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("446653951");
                        if (obj != null && (obj instanceof fk3)) {
                            fk3Var = (fk3) obj;
                        } else {
                            fk3Var = new fk3(this.mSwanApiContext);
                            this.mApis.put("446653951", fk3Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(fk3Var, "swanAPI/getBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "PrivateAccount.getBDUSS")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = fk3Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateBusiness", new Object(zq1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
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
                public String getOpenBDUSS(String str) {
                    gk3 gk3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-404108695");
                        if (obj != null && (obj instanceof gk3)) {
                            gk3Var = (gk3) obj;
                        } else {
                            gk3Var = new gk3(this.mSwanApiContext);
                            this.mApis.put("-404108695", gk3Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(gk3Var, "swanAPI/getOpenBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "PrivateBusiness.getOpenBDUSS")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 y = gk3Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryQuickLoginInfo(String str) {
                    hk3 hk3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof hk3)) {
                            hk3Var = (hk3) obj;
                        } else {
                            hk3Var = new hk3(this.mSwanApiContext);
                            this.mApis.put("1495818240", hk3Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(hk3Var, "swanAPI/queryQuickLoginInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "PrivateBusiness.queryQuickLoginInfo")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 F = hk3Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String quickLogin(String str) {
                    hk3 hk3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof hk3)) {
                            hk3Var = (hk3) obj;
                        } else {
                            hk3Var = new hk3(this.mSwanApiContext);
                            this.mApis.put("1495818240", hk3Var);
                        }
                        Pair<Boolean, xu1> a = zu1.a(hk3Var, "swanAPI/quickLogin");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((xu1) a.second).a();
                        }
                        if (f52.a(this.mSwanApiContext.f(), "PrivateBusiness.quickLogin")) {
                            return new yu1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        yu1 G = hk3Var.G(str);
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
