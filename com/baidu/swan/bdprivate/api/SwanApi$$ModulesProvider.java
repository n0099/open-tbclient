package com.baidu.swan.bdprivate.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.iw1;
import com.baidu.tieba.jw1;
import com.baidu.tieba.ks1;
import com.baidu.tieba.kw1;
import com.baidu.tieba.q62;
import com.baidu.tieba.ql3;
import com.baidu.tieba.rl3;
import com.baidu.tieba.sl3;
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

    public static Map<String, Object> getV8ApiModules(final ks1 ks1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, ks1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naPrivateAccount", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String getBDUSS(String str) {
                    ql3 ql3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("446653951");
                        if (obj != null && (obj instanceof ql3)) {
                            ql3Var = (ql3) obj;
                        } else {
                            ql3Var = new ql3(this.mSwanApiContext);
                            this.mApis.put("446653951", ql3Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ql3Var, "swanAPI/getBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "PrivateAccount.getBDUSS")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = ql3Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateBusiness", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String getOpenBDUSS(String str) {
                    rl3 rl3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-404108695");
                        if (obj != null && (obj instanceof rl3)) {
                            rl3Var = (rl3) obj;
                        } else {
                            rl3Var = new rl3(this.mSwanApiContext);
                            this.mApis.put("-404108695", rl3Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(rl3Var, "swanAPI/getOpenBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "PrivateBusiness.getOpenBDUSS")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = rl3Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryQuickLoginInfo(String str) {
                    sl3 sl3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof sl3)) {
                            sl3Var = (sl3) obj;
                        } else {
                            sl3Var = new sl3(this.mSwanApiContext);
                            this.mApis.put("1495818240", sl3Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(sl3Var, "swanAPI/queryQuickLoginInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "PrivateBusiness.queryQuickLoginInfo")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 F = sl3Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String quickLogin(String str) {
                    sl3 sl3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof sl3)) {
                            sl3Var = (sl3) obj;
                        } else {
                            sl3Var = new sl3(this.mSwanApiContext);
                            this.mApis.put("1495818240", sl3Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(sl3Var, "swanAPI/quickLogin");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "PrivateBusiness.quickLogin")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 G = sl3Var.G(str);
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

    public static Map<String, Object> getWebviewApiModules(final ks1 ks1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ks1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naPrivateAccount", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String getBDUSS(String str) {
                    ql3 ql3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("446653951");
                        if (obj != null && (obj instanceof ql3)) {
                            ql3Var = (ql3) obj;
                        } else {
                            ql3Var = new ql3(this.mSwanApiContext);
                            this.mApis.put("446653951", ql3Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(ql3Var, "swanAPI/getBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "PrivateAccount.getBDUSS")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = ql3Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateBusiness", new Object(ks1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public ks1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {ks1Var};
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
                    this.mSwanApiContext = ks1Var;
                }

                @JavascriptInterface
                public String getOpenBDUSS(String str) {
                    rl3 rl3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-404108695");
                        if (obj != null && (obj instanceof rl3)) {
                            rl3Var = (rl3) obj;
                        } else {
                            rl3Var = new rl3(this.mSwanApiContext);
                            this.mApis.put("-404108695", rl3Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(rl3Var, "swanAPI/getOpenBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "PrivateBusiness.getOpenBDUSS")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 y = rl3Var.y(str);
                        if (y == null) {
                            return "";
                        }
                        return y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryQuickLoginInfo(String str) {
                    sl3 sl3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof sl3)) {
                            sl3Var = (sl3) obj;
                        } else {
                            sl3Var = new sl3(this.mSwanApiContext);
                            this.mApis.put("1495818240", sl3Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(sl3Var, "swanAPI/queryQuickLoginInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "PrivateBusiness.queryQuickLoginInfo")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 F = sl3Var.F(str);
                        if (F == null) {
                            return "";
                        }
                        return F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String quickLogin(String str) {
                    sl3 sl3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof sl3)) {
                            sl3Var = (sl3) obj;
                        } else {
                            sl3Var = new sl3(this.mSwanApiContext);
                            this.mApis.put("1495818240", sl3Var);
                        }
                        Pair<Boolean, iw1> a = kw1.a(sl3Var, "swanAPI/quickLogin");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((iw1) a.second).a();
                        }
                        if (q62.a(this.mSwanApiContext.f(), "PrivateBusiness.quickLogin")) {
                            return new jw1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        jw1 G = sl3Var.G(str);
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
