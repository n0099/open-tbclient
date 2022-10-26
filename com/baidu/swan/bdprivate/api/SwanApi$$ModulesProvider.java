package com.baidu.swan.bdprivate.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.lv1;
import com.baidu.tieba.mv1;
import com.baidu.tieba.nr1;
import com.baidu.tieba.nv1;
import com.baidu.tieba.t52;
import com.baidu.tieba.tk3;
import com.baidu.tieba.uk3;
import com.baidu.tieba.vk3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
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

    public static Map getV8ApiModules(final nr1 nr1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, nr1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naPrivateAccount", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String getBDUSS(String str) {
                    tk3 tk3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("446653951");
                        if (obj != null && (obj instanceof tk3)) {
                            tk3Var = (tk3) obj;
                        } else {
                            tk3Var = new tk3(this.mSwanApiContext);
                            this.mApis.put("446653951", tk3Var);
                        }
                        Pair a = nv1.a(tk3Var, "swanAPI/getBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "PrivateAccount.getBDUSS")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = tk3Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateBusiness", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String getOpenBDUSS(String str) {
                    uk3 uk3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-404108695");
                        if (obj != null && (obj instanceof uk3)) {
                            uk3Var = (uk3) obj;
                        } else {
                            uk3Var = new uk3(this.mSwanApiContext);
                            this.mApis.put("-404108695", uk3Var);
                        }
                        Pair a = nv1.a(uk3Var, "swanAPI/getOpenBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "PrivateBusiness.getOpenBDUSS")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = uk3Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryQuickLoginInfo(String str) {
                    vk3 vk3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof vk3)) {
                            vk3Var = (vk3) obj;
                        } else {
                            vk3Var = new vk3(this.mSwanApiContext);
                            this.mApis.put("1495818240", vk3Var);
                        }
                        Pair a = nv1.a(vk3Var, "swanAPI/queryQuickLoginInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "PrivateBusiness.queryQuickLoginInfo")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 F = vk3Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String quickLogin(String str) {
                    vk3 vk3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof vk3)) {
                            vk3Var = (vk3) obj;
                        } else {
                            vk3Var = new vk3(this.mSwanApiContext);
                            this.mApis.put("1495818240", vk3Var);
                        }
                        Pair a = nv1.a(vk3Var, "swanAPI/quickLogin");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "PrivateBusiness.quickLogin")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 G = vk3Var.G(str);
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

    public static Map getWebviewApiModules(final nr1 nr1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, nr1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naPrivateAccount", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String getBDUSS(String str) {
                    tk3 tk3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("446653951");
                        if (obj != null && (obj instanceof tk3)) {
                            tk3Var = (tk3) obj;
                        } else {
                            tk3Var = new tk3(this.mSwanApiContext);
                            this.mApis.put("446653951", tk3Var);
                        }
                        Pair a = nv1.a(tk3Var, "swanAPI/getBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "PrivateAccount.getBDUSS")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = tk3Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateBusiness", new Object(nr1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap mApis;
                public nr1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {nr1Var};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap();
                    this.mSwanApiContext = nr1Var;
                }

                @JavascriptInterface
                public String getOpenBDUSS(String str) {
                    uk3 uk3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-404108695");
                        if (obj != null && (obj instanceof uk3)) {
                            uk3Var = (uk3) obj;
                        } else {
                            uk3Var = new uk3(this.mSwanApiContext);
                            this.mApis.put("-404108695", uk3Var);
                        }
                        Pair a = nv1.a(uk3Var, "swanAPI/getOpenBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "PrivateBusiness.getOpenBDUSS")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 y = uk3Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryQuickLoginInfo(String str) {
                    vk3 vk3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof vk3)) {
                            vk3Var = (vk3) obj;
                        } else {
                            vk3Var = new vk3(this.mSwanApiContext);
                            this.mApis.put("1495818240", vk3Var);
                        }
                        Pair a = nv1.a(vk3Var, "swanAPI/queryQuickLoginInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "PrivateBusiness.queryQuickLoginInfo")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 F = vk3Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String quickLogin(String str) {
                    vk3 vk3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof vk3)) {
                            vk3Var = (vk3) obj;
                        } else {
                            vk3Var = new vk3(this.mSwanApiContext);
                            this.mApis.put("1495818240", vk3Var);
                        }
                        Pair a = nv1.a(vk3Var, "swanAPI/quickLogin");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((lv1) a.second).a();
                        }
                        if (t52.a(this.mSwanApiContext.f(), "PrivateBusiness.quickLogin")) {
                            return new mv1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        mv1 G = vk3Var.G(str);
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
