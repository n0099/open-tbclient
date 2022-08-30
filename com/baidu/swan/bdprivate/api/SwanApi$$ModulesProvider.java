package com.baidu.swan.bdprivate.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.at1;
import com.baidu.tieba.bp1;
import com.baidu.tieba.bt1;
import com.baidu.tieba.gi3;
import com.baidu.tieba.h32;
import com.baidu.tieba.hi3;
import com.baidu.tieba.ii3;
import com.baidu.tieba.zs1;
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

    public static Map<String, Object> getV8ApiModules(final bp1 bp1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bp1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naPrivateAccount", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String getBDUSS(String str) {
                    gi3 gi3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("446653951");
                        if (obj != null && (obj instanceof gi3)) {
                            gi3Var = (gi3) obj;
                        } else {
                            gi3Var = new gi3(this.mSwanApiContext);
                            this.mApis.put("446653951", gi3Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(gi3Var, "swanAPI/getBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "PrivateAccount.getBDUSS")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = gi3Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateBusiness", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String getOpenBDUSS(String str) {
                    hi3 hi3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-404108695");
                        if (obj != null && (obj instanceof hi3)) {
                            hi3Var = (hi3) obj;
                        } else {
                            hi3Var = new hi3(this.mSwanApiContext);
                            this.mApis.put("-404108695", hi3Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(hi3Var, "swanAPI/getOpenBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "PrivateBusiness.getOpenBDUSS")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = hi3Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryQuickLoginInfo(String str) {
                    ii3 ii3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof ii3)) {
                            ii3Var = (ii3) obj;
                        } else {
                            ii3Var = new ii3(this.mSwanApiContext);
                            this.mApis.put("1495818240", ii3Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(ii3Var, "swanAPI/queryQuickLoginInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "PrivateBusiness.queryQuickLoginInfo")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 F = ii3Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String quickLogin(String str) {
                    ii3 ii3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof ii3)) {
                            ii3Var = (ii3) obj;
                        } else {
                            ii3Var = new ii3(this.mSwanApiContext);
                            this.mApis.put("1495818240", ii3Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(ii3Var, "swanAPI/quickLogin");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "PrivateBusiness.quickLogin")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 G = ii3Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static Map<String, Object> getWebviewApiModules(final bp1 bp1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bp1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naPrivateAccount", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String getBDUSS(String str) {
                    gi3 gi3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("446653951");
                        if (obj != null && (obj instanceof gi3)) {
                            gi3Var = (gi3) obj;
                        } else {
                            gi3Var = new gi3(this.mSwanApiContext);
                            this.mApis.put("446653951", gi3Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(gi3Var, "swanAPI/getBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "PrivateAccount.getBDUSS")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = gi3Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateBusiness", new Object(bp1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public bp1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bp1Var};
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
                    this.mSwanApiContext = bp1Var;
                }

                @JavascriptInterface
                public String getOpenBDUSS(String str) {
                    hi3 hi3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-404108695");
                        if (obj != null && (obj instanceof hi3)) {
                            hi3Var = (hi3) obj;
                        } else {
                            hi3Var = new hi3(this.mSwanApiContext);
                            this.mApis.put("-404108695", hi3Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(hi3Var, "swanAPI/getOpenBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "PrivateBusiness.getOpenBDUSS")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 y = hi3Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryQuickLoginInfo(String str) {
                    ii3 ii3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof ii3)) {
                            ii3Var = (ii3) obj;
                        } else {
                            ii3Var = new ii3(this.mSwanApiContext);
                            this.mApis.put("1495818240", ii3Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(ii3Var, "swanAPI/queryQuickLoginInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "PrivateBusiness.queryQuickLoginInfo")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 F = ii3Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String quickLogin(String str) {
                    ii3 ii3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof ii3)) {
                            ii3Var = (ii3) obj;
                        } else {
                            ii3Var = new ii3(this.mSwanApiContext);
                            this.mApis.put("1495818240", ii3Var);
                        }
                        Pair<Boolean, zs1> a = bt1.a(ii3Var, "swanAPI/quickLogin");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((zs1) a.second).a();
                        }
                        if (h32.a(this.mSwanApiContext.e(), "PrivateBusiness.quickLogin")) {
                            return new at1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        at1 G = ii3Var.G(str);
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
