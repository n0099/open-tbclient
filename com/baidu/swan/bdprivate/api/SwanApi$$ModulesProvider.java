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
import com.repackage.gr1;
import com.repackage.hr1;
import com.repackage.in1;
import com.repackage.ir1;
import com.repackage.ng3;
import com.repackage.o12;
import com.repackage.og3;
import com.repackage.pg3;
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

    public static Map<String, Object> getV8ApiModules(final in1 in1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, in1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naPrivateAccount", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
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
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String getBDUSS(String str) {
                    ng3 ng3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("446653951");
                        if (obj != null && (obj instanceof ng3)) {
                            ng3Var = (ng3) obj;
                        } else {
                            ng3Var = new ng3(this.mSwanApiContext);
                            this.mApis.put("446653951", ng3Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ng3Var, "swanAPI/getBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "PrivateAccount.getBDUSS")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = ng3Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateBusiness", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
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
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String getOpenBDUSS(String str) {
                    og3 og3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-404108695");
                        if (obj != null && (obj instanceof og3)) {
                            og3Var = (og3) obj;
                        } else {
                            og3Var = new og3(this.mSwanApiContext);
                            this.mApis.put("-404108695", og3Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(og3Var, "swanAPI/getOpenBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "PrivateBusiness.getOpenBDUSS")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = og3Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryQuickLoginInfo(String str) {
                    pg3 pg3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof pg3)) {
                            pg3Var = (pg3) obj;
                        } else {
                            pg3Var = new pg3(this.mSwanApiContext);
                            this.mApis.put("1495818240", pg3Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(pg3Var, "swanAPI/queryQuickLoginInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "PrivateBusiness.queryQuickLoginInfo")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 F = pg3Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String quickLogin(String str) {
                    pg3 pg3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof pg3)) {
                            pg3Var = (pg3) obj;
                        } else {
                            pg3Var = new pg3(this.mSwanApiContext);
                            this.mApis.put("1495818240", pg3Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(pg3Var, "swanAPI/quickLogin");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "PrivateBusiness.quickLogin")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 G = pg3Var.G(str);
                        return G == null ? "" : G.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static Map<String, Object> getWebviewApiModules(final in1 in1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, in1Var)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naPrivateAccount", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
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
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String getBDUSS(String str) {
                    ng3 ng3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("446653951");
                        if (obj != null && (obj instanceof ng3)) {
                            ng3Var = (ng3) obj;
                        } else {
                            ng3Var = new ng3(this.mSwanApiContext);
                            this.mApis.put("446653951", ng3Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(ng3Var, "swanAPI/getBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "PrivateAccount.getBDUSS")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = ng3Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateBusiness", new Object(in1Var) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG = false;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public in1 mSwanApiContext;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {in1Var};
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
                    this.mSwanApiContext = in1Var;
                }

                @JavascriptInterface
                public String getOpenBDUSS(String str) {
                    og3 og3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        Object obj = this.mApis.get("-404108695");
                        if (obj != null && (obj instanceof og3)) {
                            og3Var = (og3) obj;
                        } else {
                            og3Var = new og3(this.mSwanApiContext);
                            this.mApis.put("-404108695", og3Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(og3Var, "swanAPI/getOpenBDUSS");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "PrivateBusiness.getOpenBDUSS")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 y = og3Var.y(str);
                        return y == null ? "" : y.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryQuickLoginInfo(String str) {
                    pg3 pg3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof pg3)) {
                            pg3Var = (pg3) obj;
                        } else {
                            pg3Var = new pg3(this.mSwanApiContext);
                            this.mApis.put("1495818240", pg3Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(pg3Var, "swanAPI/queryQuickLoginInfo");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "PrivateBusiness.queryQuickLoginInfo")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 F = pg3Var.F(str);
                        return F == null ? "" : F.a();
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String quickLogin(String str) {
                    pg3 pg3Var;
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        Object obj = this.mApis.get("1495818240");
                        if (obj != null && (obj instanceof pg3)) {
                            pg3Var = (pg3) obj;
                        } else {
                            pg3Var = new pg3(this.mSwanApiContext);
                            this.mApis.put("1495818240", pg3Var);
                        }
                        Pair<Boolean, gr1> a = ir1.a(pg3Var, "swanAPI/quickLogin");
                        if (((Boolean) a.first).booleanValue()) {
                            return ((gr1) a.second).a();
                        }
                        if (o12.a(this.mSwanApiContext.h(), "PrivateBusiness.quickLogin")) {
                            return new hr1(1001, "illegal swanApp, intercept for preload/prefetch").a();
                        }
                        hr1 G = pg3Var.G(str);
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
