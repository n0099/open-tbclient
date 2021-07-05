package com.baidu.swan.bdprivate.api;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.h0.l.g.f;
import d.a.q0.a.u.c.b;
import d.a.q0.a.u.c.d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes4.dex */
public class SwanApi$$ModulesProvider {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public SwanApi$$ModulesProvider() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static Map<String, Object> getV8ApiModules(final b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, bVar)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naPrivateAccount", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                /* loaded from: classes4.dex */
                public class a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ Throwable f10736e;

                    public a(SwanApi$$PrivateAccountV8Module swanApi$$PrivateAccountV8Module, Throwable th) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {swanApi$$PrivateAccountV8Module, th};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f10736e = th;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            throw this.f10736e;
                        }
                    }
                }

                static {
                    InterceptResult invokeClinit;
                    ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                    if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1567944092, "Lcom/baidu/swan/apps/api/SwanApi$$PrivateAccountV8Module;")) != null) {
                        Interceptable interceptable2 = invokeClinit.interceptor;
                        if (interceptable2 != null) {
                            $ic = interceptable2;
                        }
                        if ((invokeClinit.flags & 1) != 0) {
                            classClinitInterceptable.invokePostClinit(1567944092, "Lcom/baidu/swan/apps/api/SwanApi$$PrivateAccountV8Module;");
                            return;
                        }
                    }
                    DEBUG = d.f50740c;
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65537, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65537, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String getBDUSS(String str) {
                    InterceptResult invokeL2;
                    d.a.q0.b.l.a aVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        try {
                            if (DEBUG) {
                                Log.d("Api-Base", "====================PrivateAccount.getBDUSS[type:V8, v8 binding:false]====================");
                            }
                            Object obj = this.mApis.get("446653951");
                            if (obj != null && (obj instanceof d.a.q0.b.l.a)) {
                                aVar = (d.a.q0.b.l.a) obj;
                            } else {
                                aVar = new d.a.q0.b.l.a(this.mSwanApiContext);
                                this.mApis.put("446653951", aVar);
                            }
                            Pair<Boolean, d.a.q0.a.u.h.a> a2 = d.a.q0.a.u.i.a.a(aVar, "swanAPI/getBDUSS");
                            if (((Boolean) a2.first).booleanValue()) {
                                return ((d.a.q0.a.u.h.a) a2.second).a();
                            }
                            if (f.a(this.mSwanApiContext.g(), "PrivateAccount.getBDUSS")) {
                                return new d.a.q0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            }
                            d.a.q0.a.u.h.b s = aVar.s(str);
                            String a3 = s == null ? "" : s.a();
                            if (DEBUG) {
                                Log.d("Api-Base", "====================[[PrivateAccount.getBDUSS[type:V8, v8 binding:false] result]]" + a3);
                            }
                            return a3;
                        } catch (Throwable th) {
                            if (DEBUG) {
                                Log.e("Api-Base", "====================[[PrivateAccount.getBDUSS[type:V8, v8 binding:false] with exception]]", th);
                                new Handler(Looper.getMainLooper()).post(new a(this, th));
                                return "";
                            }
                            throw th;
                        }
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateBusiness", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public d.a.q0.a.u.c.b mSwanApiContext;

                /* loaded from: classes4.dex */
                public class a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ Throwable f10738e;

                    public a(SwanApi$$PrivateBusinessV8Module swanApi$$PrivateBusinessV8Module, Throwable th) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {swanApi$$PrivateBusinessV8Module, th};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f10738e = th;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            throw this.f10738e;
                        }
                    }
                }

                /* loaded from: classes4.dex */
                public class b implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ Throwable f10739e;

                    public b(SwanApi$$PrivateBusinessV8Module swanApi$$PrivateBusinessV8Module, Throwable th) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {swanApi$$PrivateBusinessV8Module, th};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f10739e = th;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            throw this.f10739e;
                        }
                    }
                }

                /* loaded from: classes4.dex */
                public class c implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ Throwable f10740e;

                    public c(SwanApi$$PrivateBusinessV8Module swanApi$$PrivateBusinessV8Module, Throwable th) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {swanApi$$PrivateBusinessV8Module, th};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f10740e = th;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            throw this.f10740e;
                        }
                    }
                }

                static {
                    InterceptResult invokeClinit;
                    ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                    if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(50574129, "Lcom/baidu/swan/apps/api/SwanApi$$PrivateBusinessV8Module;")) != null) {
                        Interceptable interceptable2 = invokeClinit.interceptor;
                        if (interceptable2 != null) {
                            $ic = interceptable2;
                        }
                        if ((invokeClinit.flags & 1) != 0) {
                            classClinitInterceptable.invokePostClinit(50574129, "Lcom/baidu/swan/apps/api/SwanApi$$PrivateBusinessV8Module;");
                            return;
                        }
                    }
                    DEBUG = d.f50740c;
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65537, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65537, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String getOpenBDUSS(String str) {
                    InterceptResult invokeL2;
                    d.a.q0.b.l.b bVar2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        try {
                            if (DEBUG) {
                                Log.d("Api-Base", "====================PrivateBusiness.getOpenBDUSS[type:V8, v8 binding:false]====================");
                            }
                            Object obj = this.mApis.get("-404108695");
                            if (obj != null && (obj instanceof d.a.q0.b.l.b)) {
                                bVar2 = (d.a.q0.b.l.b) obj;
                            } else {
                                bVar2 = new d.a.q0.b.l.b(this.mSwanApiContext);
                                this.mApis.put("-404108695", bVar2);
                            }
                            Pair<Boolean, d.a.q0.a.u.h.a> a2 = d.a.q0.a.u.i.a.a(bVar2, "swanAPI/getOpenBDUSS");
                            if (((Boolean) a2.first).booleanValue()) {
                                return ((d.a.q0.a.u.h.a) a2.second).a();
                            }
                            if (f.a(this.mSwanApiContext.g(), "PrivateBusiness.getOpenBDUSS")) {
                                return new d.a.q0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            }
                            d.a.q0.a.u.h.b s = bVar2.s(str);
                            String a3 = s == null ? "" : s.a();
                            if (DEBUG) {
                                Log.d("Api-Base", "====================[[PrivateBusiness.getOpenBDUSS[type:V8, v8 binding:false] result]]" + a3);
                            }
                            return a3;
                        } catch (Throwable th) {
                            if (DEBUG) {
                                Log.e("Api-Base", "====================[[PrivateBusiness.getOpenBDUSS[type:V8, v8 binding:false] with exception]]", th);
                                new Handler(Looper.getMainLooper()).post(new a(this, th));
                                return "";
                            }
                            throw th;
                        }
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryQuickLoginInfo(String str) {
                    InterceptResult invokeL2;
                    d.a.q0.b.l.c cVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        try {
                            if (DEBUG) {
                                Log.d("Api-Base", "====================PrivateBusiness.queryQuickLoginInfo[type:V8, v8 binding:false]====================");
                            }
                            Object obj = this.mApis.get("1495818240");
                            if (obj != null && (obj instanceof d.a.q0.b.l.c)) {
                                cVar = (d.a.q0.b.l.c) obj;
                            } else {
                                cVar = new d.a.q0.b.l.c(this.mSwanApiContext);
                                this.mApis.put("1495818240", cVar);
                            }
                            Pair<Boolean, d.a.q0.a.u.h.a> a2 = d.a.q0.a.u.i.a.a(cVar, "swanAPI/queryQuickLoginInfo");
                            if (((Boolean) a2.first).booleanValue()) {
                                return ((d.a.q0.a.u.h.a) a2.second).a();
                            }
                            if (f.a(this.mSwanApiContext.g(), "PrivateBusiness.queryQuickLoginInfo")) {
                                return new d.a.q0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            }
                            d.a.q0.a.u.h.b z = cVar.z(str);
                            String a3 = z == null ? "" : z.a();
                            if (DEBUG) {
                                Log.d("Api-Base", "====================[[PrivateBusiness.queryQuickLoginInfo[type:V8, v8 binding:false] result]]" + a3);
                            }
                            return a3;
                        } catch (Throwable th) {
                            if (DEBUG) {
                                Log.e("Api-Base", "====================[[PrivateBusiness.queryQuickLoginInfo[type:V8, v8 binding:false] with exception]]", th);
                                new Handler(Looper.getMainLooper()).post(new b(this, th));
                                return "";
                            }
                            throw th;
                        }
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String quickLogin(String str) {
                    InterceptResult invokeL2;
                    d.a.q0.b.l.c cVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        try {
                            if (DEBUG) {
                                Log.d("Api-Base", "====================PrivateBusiness.quickLogin[type:V8, v8 binding:false]====================");
                            }
                            Object obj = this.mApis.get("1495818240");
                            if (obj != null && (obj instanceof d.a.q0.b.l.c)) {
                                cVar = (d.a.q0.b.l.c) obj;
                            } else {
                                cVar = new d.a.q0.b.l.c(this.mSwanApiContext);
                                this.mApis.put("1495818240", cVar);
                            }
                            Pair<Boolean, d.a.q0.a.u.h.a> a2 = d.a.q0.a.u.i.a.a(cVar, "swanAPI/quickLogin");
                            if (((Boolean) a2.first).booleanValue()) {
                                return ((d.a.q0.a.u.h.a) a2.second).a();
                            }
                            if (f.a(this.mSwanApiContext.g(), "PrivateBusiness.quickLogin")) {
                                return new d.a.q0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            }
                            d.a.q0.a.u.h.b A = cVar.A(str);
                            String a3 = A == null ? "" : A.a();
                            if (DEBUG) {
                                Log.d("Api-Base", "====================[[PrivateBusiness.quickLogin[type:V8, v8 binding:false] result]]" + a3);
                            }
                            return a3;
                        } catch (Throwable th) {
                            if (DEBUG) {
                                Log.e("Api-Base", "====================[[PrivateBusiness.quickLogin[type:V8, v8 binding:false] with exception]]", th);
                                new Handler(Looper.getMainLooper()).post(new c(this, th));
                                return "";
                            }
                            throw th;
                        }
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateUtils", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateUtilsV8Module
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                /* loaded from: classes4.dex */
                public class a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ Throwable f10746e;

                    public a(SwanApi$$PrivateUtilsV8Module swanApi$$PrivateUtilsV8Module, Throwable th) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {swanApi$$PrivateUtilsV8Module, th};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f10746e = th;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            throw this.f10746e;
                        }
                    }
                }

                static {
                    InterceptResult invokeClinit;
                    ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                    if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-500202856, "Lcom/baidu/swan/apps/api/SwanApi$$PrivateUtilsV8Module;")) != null) {
                        Interceptable interceptable2 = invokeClinit.interceptor;
                        if (interceptable2 != null) {
                            $ic = interceptable2;
                        }
                        if ((invokeClinit.flags & 1) != 0) {
                            classClinitInterceptable.invokePostClinit(-500202856, "Lcom/baidu/swan/apps/api/SwanApi$$PrivateUtilsV8Module;");
                            return;
                        }
                    }
                    DEBUG = d.f50740c;
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65537, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65537, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    InterceptResult invokeL2;
                    d.a.q0.b.n.c.a aVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        try {
                            if (DEBUG) {
                                Log.d("Api-Base", "====================PrivateUtils.getCommonSysInfo[type:V8, v8 binding:false]====================");
                            }
                            Object obj = this.mApis.get("-599878304");
                            if (obj != null && (obj instanceof d.a.q0.b.n.c.a)) {
                                aVar = (d.a.q0.b.n.c.a) obj;
                            } else {
                                aVar = new d.a.q0.b.n.c.a(this.mSwanApiContext);
                                this.mApis.put("-599878304", aVar);
                            }
                            Pair<Boolean, d.a.q0.a.u.h.a> a2 = d.a.q0.a.u.i.a.a(aVar, "swanAPI/getCommonSysInfo");
                            if (((Boolean) a2.first).booleanValue()) {
                                return ((d.a.q0.a.u.h.a) a2.second).a();
                            }
                            if (f.a(this.mSwanApiContext.g(), "PrivateUtils.getCommonSysInfo")) {
                                return new d.a.q0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            }
                            d.a.q0.a.u.h.b s = aVar.s(str);
                            String a3 = s == null ? "" : s.a();
                            if (DEBUG) {
                                Log.d("Api-Base", "====================[[PrivateUtils.getCommonSysInfo[type:V8, v8 binding:false] result]]" + a3);
                            }
                            return a3;
                        } catch (Throwable th) {
                            if (DEBUG) {
                                Log.e("Api-Base", "====================[[PrivateUtils.getCommonSysInfo[type:V8, v8 binding:false] with exception]]", th);
                                new Handler(Looper.getMainLooper()).post(new a(this, th));
                                return "";
                            }
                            throw th;
                        }
                    }
                    return (String) invokeL2.objValue;
                }
            });
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }

    public static Map<String, Object> getWebviewApiModules(final b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, bVar)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("_naPrivateAccount", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateAccountWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                /* loaded from: classes4.dex */
                public class a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ Throwable f10737e;

                    public a(SwanApi$$PrivateAccountWebviewModule swanApi$$PrivateAccountWebviewModule, Throwable th) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {swanApi$$PrivateAccountWebviewModule, th};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f10737e = th;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            throw this.f10737e;
                        }
                    }
                }

                static {
                    InterceptResult invokeClinit;
                    ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                    if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1161313095, "Lcom/baidu/swan/apps/api/SwanApi$$PrivateAccountWebviewModule;")) != null) {
                        Interceptable interceptable2 = invokeClinit.interceptor;
                        if (interceptable2 != null) {
                            $ic = interceptable2;
                        }
                        if ((invokeClinit.flags & 1) != 0) {
                            classClinitInterceptable.invokePostClinit(1161313095, "Lcom/baidu/swan/apps/api/SwanApi$$PrivateAccountWebviewModule;");
                            return;
                        }
                    }
                    DEBUG = d.f50740c;
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65537, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65537, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String getBDUSS(String str) {
                    InterceptResult invokeL2;
                    d.a.q0.b.l.a aVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        try {
                            if (DEBUG) {
                                Log.d("Api-Base", "====================PrivateAccount.getBDUSS[type:Webview, v8 binding:false]====================");
                            }
                            Object obj = this.mApis.get("446653951");
                            if (obj != null && (obj instanceof d.a.q0.b.l.a)) {
                                aVar = (d.a.q0.b.l.a) obj;
                            } else {
                                aVar = new d.a.q0.b.l.a(this.mSwanApiContext);
                                this.mApis.put("446653951", aVar);
                            }
                            Pair<Boolean, d.a.q0.a.u.h.a> a2 = d.a.q0.a.u.i.a.a(aVar, "swanAPI/getBDUSS");
                            if (((Boolean) a2.first).booleanValue()) {
                                return ((d.a.q0.a.u.h.a) a2.second).a();
                            }
                            if (f.a(this.mSwanApiContext.g(), "PrivateAccount.getBDUSS")) {
                                return new d.a.q0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            }
                            d.a.q0.a.u.h.b s = aVar.s(str);
                            String a3 = s == null ? "" : s.a();
                            if (DEBUG) {
                                Log.d("Api-Base", "====================[[PrivateAccount.getBDUSS[type:Webview, v8 binding:false] result]]" + a3);
                            }
                            return a3;
                        } catch (Throwable th) {
                            if (DEBUG) {
                                Log.e("Api-Base", "====================[[PrivateAccount.getBDUSS[type:Webview, v8 binding:false] with exception]]", th);
                                new Handler(Looper.getMainLooper()).post(new a(this, th));
                                return "";
                            }
                            throw th;
                        }
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateBusiness", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateBusinessWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public d.a.q0.a.u.c.b mSwanApiContext;

                /* loaded from: classes4.dex */
                public class a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ Throwable f10741e;

                    public a(SwanApi$$PrivateBusinessWebviewModule swanApi$$PrivateBusinessWebviewModule, Throwable th) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {swanApi$$PrivateBusinessWebviewModule, th};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f10741e = th;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            throw this.f10741e;
                        }
                    }
                }

                /* loaded from: classes4.dex */
                public class b implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ Throwable f10742e;

                    public b(SwanApi$$PrivateBusinessWebviewModule swanApi$$PrivateBusinessWebviewModule, Throwable th) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {swanApi$$PrivateBusinessWebviewModule, th};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f10742e = th;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            throw this.f10742e;
                        }
                    }
                }

                /* loaded from: classes4.dex */
                public class c implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ Throwable f10743e;

                    public c(SwanApi$$PrivateBusinessWebviewModule swanApi$$PrivateBusinessWebviewModule, Throwable th) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {swanApi$$PrivateBusinessWebviewModule, th};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f10743e = th;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            throw this.f10743e;
                        }
                    }
                }

                static {
                    InterceptResult invokeClinit;
                    ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                    if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(291416786, "Lcom/baidu/swan/apps/api/SwanApi$$PrivateBusinessWebviewModule;")) != null) {
                        Interceptable interceptable2 = invokeClinit.interceptor;
                        if (interceptable2 != null) {
                            $ic = interceptable2;
                        }
                        if ((invokeClinit.flags & 1) != 0) {
                            classClinitInterceptable.invokePostClinit(291416786, "Lcom/baidu/swan/apps/api/SwanApi$$PrivateBusinessWebviewModule;");
                            return;
                        }
                    }
                    DEBUG = d.f50740c;
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65537, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65537, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String getOpenBDUSS(String str) {
                    InterceptResult invokeL2;
                    d.a.q0.b.l.b bVar2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        try {
                            if (DEBUG) {
                                Log.d("Api-Base", "====================PrivateBusiness.getOpenBDUSS[type:Webview, v8 binding:false]====================");
                            }
                            Object obj = this.mApis.get("-404108695");
                            if (obj != null && (obj instanceof d.a.q0.b.l.b)) {
                                bVar2 = (d.a.q0.b.l.b) obj;
                            } else {
                                bVar2 = new d.a.q0.b.l.b(this.mSwanApiContext);
                                this.mApis.put("-404108695", bVar2);
                            }
                            Pair<Boolean, d.a.q0.a.u.h.a> a2 = d.a.q0.a.u.i.a.a(bVar2, "swanAPI/getOpenBDUSS");
                            if (((Boolean) a2.first).booleanValue()) {
                                return ((d.a.q0.a.u.h.a) a2.second).a();
                            }
                            if (f.a(this.mSwanApiContext.g(), "PrivateBusiness.getOpenBDUSS")) {
                                return new d.a.q0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            }
                            d.a.q0.a.u.h.b s = bVar2.s(str);
                            String a3 = s == null ? "" : s.a();
                            if (DEBUG) {
                                Log.d("Api-Base", "====================[[PrivateBusiness.getOpenBDUSS[type:Webview, v8 binding:false] result]]" + a3);
                            }
                            return a3;
                        } catch (Throwable th) {
                            if (DEBUG) {
                                Log.e("Api-Base", "====================[[PrivateBusiness.getOpenBDUSS[type:Webview, v8 binding:false] with exception]]", th);
                                new Handler(Looper.getMainLooper()).post(new a(this, th));
                                return "";
                            }
                            throw th;
                        }
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String queryQuickLoginInfo(String str) {
                    InterceptResult invokeL2;
                    d.a.q0.b.l.c cVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        try {
                            if (DEBUG) {
                                Log.d("Api-Base", "====================PrivateBusiness.queryQuickLoginInfo[type:Webview, v8 binding:false]====================");
                            }
                            Object obj = this.mApis.get("1495818240");
                            if (obj != null && (obj instanceof d.a.q0.b.l.c)) {
                                cVar = (d.a.q0.b.l.c) obj;
                            } else {
                                cVar = new d.a.q0.b.l.c(this.mSwanApiContext);
                                this.mApis.put("1495818240", cVar);
                            }
                            Pair<Boolean, d.a.q0.a.u.h.a> a2 = d.a.q0.a.u.i.a.a(cVar, "swanAPI/queryQuickLoginInfo");
                            if (((Boolean) a2.first).booleanValue()) {
                                return ((d.a.q0.a.u.h.a) a2.second).a();
                            }
                            if (f.a(this.mSwanApiContext.g(), "PrivateBusiness.queryQuickLoginInfo")) {
                                return new d.a.q0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            }
                            d.a.q0.a.u.h.b z = cVar.z(str);
                            String a3 = z == null ? "" : z.a();
                            if (DEBUG) {
                                Log.d("Api-Base", "====================[[PrivateBusiness.queryQuickLoginInfo[type:Webview, v8 binding:false] result]]" + a3);
                            }
                            return a3;
                        } catch (Throwable th) {
                            if (DEBUG) {
                                Log.e("Api-Base", "====================[[PrivateBusiness.queryQuickLoginInfo[type:Webview, v8 binding:false] with exception]]", th);
                                new Handler(Looper.getMainLooper()).post(new b(this, th));
                                return "";
                            }
                            throw th;
                        }
                    }
                    return (String) invokeL2.objValue;
                }

                @JavascriptInterface
                public String quickLogin(String str) {
                    InterceptResult invokeL2;
                    d.a.q0.b.l.c cVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        try {
                            if (DEBUG) {
                                Log.d("Api-Base", "====================PrivateBusiness.quickLogin[type:Webview, v8 binding:false]====================");
                            }
                            Object obj = this.mApis.get("1495818240");
                            if (obj != null && (obj instanceof d.a.q0.b.l.c)) {
                                cVar = (d.a.q0.b.l.c) obj;
                            } else {
                                cVar = new d.a.q0.b.l.c(this.mSwanApiContext);
                                this.mApis.put("1495818240", cVar);
                            }
                            Pair<Boolean, d.a.q0.a.u.h.a> a2 = d.a.q0.a.u.i.a.a(cVar, "swanAPI/quickLogin");
                            if (((Boolean) a2.first).booleanValue()) {
                                return ((d.a.q0.a.u.h.a) a2.second).a();
                            }
                            if (f.a(this.mSwanApiContext.g(), "PrivateBusiness.quickLogin")) {
                                return new d.a.q0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            }
                            d.a.q0.a.u.h.b A = cVar.A(str);
                            String a3 = A == null ? "" : A.a();
                            if (DEBUG) {
                                Log.d("Api-Base", "====================[[PrivateBusiness.quickLogin[type:Webview, v8 binding:false] result]]" + a3);
                            }
                            return a3;
                        } catch (Throwable th) {
                            if (DEBUG) {
                                Log.e("Api-Base", "====================[[PrivateBusiness.quickLogin[type:Webview, v8 binding:false] with exception]]", th);
                                new Handler(Looper.getMainLooper()).post(new c(this, th));
                                return "";
                            }
                            throw th;
                        }
                    }
                    return (String) invokeL2.objValue;
                }
            });
            hashMap.put("_naPrivateUtils", new Object(bVar) { // from class: com.baidu.swan.apps.api.SwanApi$$PrivateUtilsWebviewModule
                public static /* synthetic */ Interceptable $ic = null;
                public static final boolean DEBUG;
                public static final String TAG = "Api-Base";
                public transient /* synthetic */ FieldHolder $fh;
                public ConcurrentHashMap<String, Object> mApis;
                public b mSwanApiContext;

                /* loaded from: classes4.dex */
                public class a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ Throwable f10747e;

                    public a(SwanApi$$PrivateUtilsWebviewModule swanApi$$PrivateUtilsWebviewModule, Throwable th) {
                        Interceptable interceptable = $ic;
                        if (interceptable != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {swanApi$$PrivateUtilsWebviewModule, th};
                            interceptable.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f10747e = th;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            throw this.f10747e;
                        }
                    }
                }

                static {
                    InterceptResult invokeClinit;
                    ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
                    if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-536910901, "Lcom/baidu/swan/apps/api/SwanApi$$PrivateUtilsWebviewModule;")) != null) {
                        Interceptable interceptable2 = invokeClinit.interceptor;
                        if (interceptable2 != null) {
                            $ic = interceptable2;
                        }
                        if ((invokeClinit.flags & 1) != 0) {
                            classClinitInterceptable.invokePostClinit(-536910901, "Lcom/baidu/swan/apps/api/SwanApi$$PrivateUtilsWebviewModule;");
                            return;
                        }
                    }
                    DEBUG = d.f50740c;
                }

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {bVar};
                        interceptable2.invokeUnInit(65537, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65537, newInitContext);
                            return;
                        }
                    }
                    this.mApis = new ConcurrentHashMap<>();
                    this.mSwanApiContext = bVar;
                }

                @JavascriptInterface
                public String getCommonSysInfo(String str) {
                    InterceptResult invokeL2;
                    d.a.q0.b.n.c.a aVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        try {
                            if (DEBUG) {
                                Log.d("Api-Base", "====================PrivateUtils.getCommonSysInfo[type:Webview, v8 binding:false]====================");
                            }
                            Object obj = this.mApis.get("-599878304");
                            if (obj != null && (obj instanceof d.a.q0.b.n.c.a)) {
                                aVar = (d.a.q0.b.n.c.a) obj;
                            } else {
                                aVar = new d.a.q0.b.n.c.a(this.mSwanApiContext);
                                this.mApis.put("-599878304", aVar);
                            }
                            Pair<Boolean, d.a.q0.a.u.h.a> a2 = d.a.q0.a.u.i.a.a(aVar, "swanAPI/getCommonSysInfo");
                            if (((Boolean) a2.first).booleanValue()) {
                                return ((d.a.q0.a.u.h.a) a2.second).a();
                            }
                            if (f.a(this.mSwanApiContext.g(), "PrivateUtils.getCommonSysInfo")) {
                                return new d.a.q0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            }
                            d.a.q0.a.u.h.b s = aVar.s(str);
                            String a3 = s == null ? "" : s.a();
                            if (DEBUG) {
                                Log.d("Api-Base", "====================[[PrivateUtils.getCommonSysInfo[type:Webview, v8 binding:false] result]]" + a3);
                            }
                            return a3;
                        } catch (Throwable th) {
                            if (DEBUG) {
                                Log.e("Api-Base", "====================[[PrivateUtils.getCommonSysInfo[type:Webview, v8 binding:false] with exception]]", th);
                                new Handler(Looper.getMainLooper()).post(new a(this, th));
                                return "";
                            }
                            throw th;
                        }
                    }
                    return (String) invokeL2.objValue;
                }
            });
            return hashMap;
        }
        return (Map) invokeL.objValue;
    }
}
