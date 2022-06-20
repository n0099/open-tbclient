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
import com.repackage.ah3;
import com.repackage.rr1;
import com.repackage.sr1;
import com.repackage.tn1;
import com.repackage.tr1;
import com.repackage.yg3;
import com.repackage.z12;
import com.repackage.zg3;
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

    public static Map<String, Object> getV8ApiModules(final tn1 tn1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tn1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naPrivateAccount", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
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
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String getBDUSS(String str) {
                    yg3 yg3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("446653951");
                        if (obj != null && (obj instanceof yg3)) {
                            yg3Var = (yg3) obj;
                        } else {
                            yg3Var = new yg3(this.mSwanApiContext);
                            this.mApis.put("446653951", yg3Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(yg3Var, "swanAPI/getBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "PrivateAccount.getBDUSS")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = yg3Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateBusiness", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
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
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String getOpenBDUSS(String str) {
                    zg3 zg3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-404108695");
                        if (obj != null && (obj instanceof zg3)) {
                            zg3Var = (zg3) obj;
                        } else {
                            zg3Var = new zg3(this.mSwanApiContext);
                            this.mApis.put("-404108695", zg3Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(zg3Var, "swanAPI/getOpenBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "PrivateBusiness.getOpenBDUSS")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = zg3Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryQuickLoginInfo(String str) {
                    ah3 ah3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof ah3)) {
                            ah3Var = (ah3) obj;
                        } else {
                            ah3Var = new ah3(this.mSwanApiContext);
                            this.mApis.put("1495818240", ah3Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ah3Var, "swanAPI/queryQuickLoginInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "PrivateBusiness.queryQuickLoginInfo")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 F = ah3Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String quickLogin(String str) {
                    ah3 ah3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof ah3)) {
                            ah3Var = (ah3) obj;
                        } else {
                            ah3Var = new ah3(this.mSwanApiContext);
                            this.mApis.put("1495818240", ah3Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ah3Var, "swanAPI/quickLogin");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "PrivateBusiness.quickLogin")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 G = ah3Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static Map<String, Object> getWebviewApiModules(final tn1 tn1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, tn1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naPrivateAccount", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
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
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String getBDUSS(String str) {
                    yg3 yg3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("446653951");
                        if (obj != null && (obj instanceof yg3)) {
                            yg3Var = (yg3) obj;
                        } else {
                            yg3Var = new yg3(this.mSwanApiContext);
                            this.mApis.put("446653951", yg3Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(yg3Var, "swanAPI/getBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "PrivateAccount.getBDUSS")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = yg3Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateBusiness", new Object(tn1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public tn1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {tn1Var};
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
                    this.mSwanApiContext = tn1Var;
                }

                @JavascriptInterface
                public String getOpenBDUSS(String str) {
                    zg3 zg3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-404108695");
                        if (obj != null && (obj instanceof zg3)) {
                            zg3Var = (zg3) obj;
                        } else {
                            zg3Var = new zg3(this.mSwanApiContext);
                            this.mApis.put("-404108695", zg3Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(zg3Var, "swanAPI/getOpenBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "PrivateBusiness.getOpenBDUSS")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 y = zg3Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryQuickLoginInfo(String str) {
                    ah3 ah3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof ah3)) {
                            ah3Var = (ah3) obj;
                        } else {
                            ah3Var = new ah3(this.mSwanApiContext);
                            this.mApis.put("1495818240", ah3Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ah3Var, "swanAPI/queryQuickLoginInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "PrivateBusiness.queryQuickLoginInfo")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 F = ah3Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String quickLogin(String str) {
                    ah3 ah3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof ah3)) {
                            ah3Var = (ah3) obj;
                        } else {
                            ah3Var = new ah3(this.mSwanApiContext);
                            this.mApis.put("1495818240", ah3Var);
                        }
                        Pair<Boolean, rr1> a = tr1.a(ah3Var, "swanAPI/quickLogin");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((rr1) a.second).a();
                        }
                        if (z12.a(this.mSwanApiContext.h(), "PrivateBusiness.quickLogin")) {
                            return new sr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        sr1 G = ah3Var.G(str);
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
