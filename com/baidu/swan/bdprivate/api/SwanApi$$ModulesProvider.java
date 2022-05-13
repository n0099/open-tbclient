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
import com.repackage.ai3;
import com.repackage.b32;
import com.repackage.bi3;
import com.repackage.ci3;
import com.repackage.ts1;
import com.repackage.us1;
import com.repackage.vo1;
import com.repackage.vs1;
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

    public static Map<String, Object> getV8ApiModules(final vo1 vo1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, vo1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naPrivateAccount", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
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
                public String getBDUSS(String str) {
                    ai3 ai3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("446653951");
                        if (obj != null && (obj instanceof ai3)) {
                            ai3Var = (ai3) obj;
                        } else {
                            ai3Var = new ai3(this.mSwanApiContext);
                            this.mApis.put("446653951", ai3Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ai3Var, "swanAPI/getBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "PrivateAccount.getBDUSS")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = ai3Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateBusiness", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
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
                public String getOpenBDUSS(String str) {
                    bi3 bi3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-404108695");
                        if (obj != null && (obj instanceof bi3)) {
                            bi3Var = (bi3) obj;
                        } else {
                            bi3Var = new bi3(this.mSwanApiContext);
                            this.mApis.put("-404108695", bi3Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(bi3Var, "swanAPI/getOpenBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "PrivateBusiness.getOpenBDUSS")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = bi3Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryQuickLoginInfo(String str) {
                    ci3 ci3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof ci3)) {
                            ci3Var = (ci3) obj;
                        } else {
                            ci3Var = new ci3(this.mSwanApiContext);
                            this.mApis.put("1495818240", ci3Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ci3Var, "swanAPI/queryQuickLoginInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "PrivateBusiness.queryQuickLoginInfo")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 F = ci3Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String quickLogin(String str) {
                    ci3 ci3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof ci3)) {
                            ci3Var = (ci3) obj;
                        } else {
                            ci3Var = new ci3(this.mSwanApiContext);
                            this.mApis.put("1495818240", ci3Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ci3Var, "swanAPI/quickLogin");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "PrivateBusiness.quickLogin")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 G = ci3Var.G(str);
                        return G == null ? "" : G.a();
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
            hashMap.put("_naPrivateAccount", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
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
                public String getBDUSS(String str) {
                    ai3 ai3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("446653951");
                        if (obj != null && (obj instanceof ai3)) {
                            ai3Var = (ai3) obj;
                        } else {
                            ai3Var = new ai3(this.mSwanApiContext);
                            this.mApis.put("446653951", ai3Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ai3Var, "swanAPI/getBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "PrivateAccount.getBDUSS")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = ai3Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateBusiness", new Object(vo1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
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
                public String getOpenBDUSS(String str) {
                    bi3 bi3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-404108695");
                        if (obj != null && (obj instanceof bi3)) {
                            bi3Var = (bi3) obj;
                        } else {
                            bi3Var = new bi3(this.mSwanApiContext);
                            this.mApis.put("-404108695", bi3Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(bi3Var, "swanAPI/getOpenBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "PrivateBusiness.getOpenBDUSS")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 y = bi3Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryQuickLoginInfo(String str) {
                    ci3 ci3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof ci3)) {
                            ci3Var = (ci3) obj;
                        } else {
                            ci3Var = new ci3(this.mSwanApiContext);
                            this.mApis.put("1495818240", ci3Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ci3Var, "swanAPI/queryQuickLoginInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "PrivateBusiness.queryQuickLoginInfo")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 F = ci3Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String quickLogin(String str) {
                    ci3 ci3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof ci3)) {
                            ci3Var = (ci3) obj;
                        } else {
                            ci3Var = new ci3(this.mSwanApiContext);
                            this.mApis.put("1495818240", ci3Var);
                        }
                        Pair<Boolean, ts1> a = vs1.a(ci3Var, "swanAPI/quickLogin");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((ts1) a.second).a();
                        }
                        if (b32.a(this.mSwanApiContext.h(), "PrivateBusiness.quickLogin")) {
                            return new us1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        us1 G = ci3Var.G(str);
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
