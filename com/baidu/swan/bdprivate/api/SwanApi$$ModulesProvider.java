package com.baidu.swan.bdprivate.api;

import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.webkit.JavascriptInterface;
import androidx.annotation.Keep;
import c.a.p0.a.h0.l.g.f;
import c.a.p0.a.u.c.b;
import c.a.p0.a.u.c.d;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
@Keep
/* loaded from: classes6.dex */
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

                /* loaded from: classes6.dex */
                public class a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ Throwable f45702e;

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
                        this.f45702e = th;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            throw this.f45702e;
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
                    DEBUG = d.f8735c;
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
                    c.a.p0.b.n.a aVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        try {
                            boolean z = DEBUG;
                            Object obj = this.mApis.get("446653951");
                            if (obj != null && (obj instanceof c.a.p0.b.n.a)) {
                                aVar = (c.a.p0.b.n.a) obj;
                            } else {
                                aVar = new c.a.p0.b.n.a(this.mSwanApiContext);
                                this.mApis.put("446653951", aVar);
                            }
                            Pair<Boolean, c.a.p0.a.u.h.a> a2 = c.a.p0.a.u.i.a.a(aVar, "swanAPI/getBDUSS");
                            if (((Boolean) a2.first).booleanValue()) {
                                return ((c.a.p0.a.u.h.a) a2.second).a();
                            }
                            if (f.a(this.mSwanApiContext.g(), "PrivateAccount.getBDUSS")) {
                                return new c.a.p0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            }
                            c.a.p0.a.u.h.b s = aVar.s(str);
                            String a3 = s == null ? "" : s.a();
                            if (DEBUG) {
                                String str2 = "====================[[PrivateAccount.getBDUSS[type:V8, v8 binding:false] result]]" + a3;
                            }
                            return a3;
                        } catch (Throwable th) {
                            if (DEBUG) {
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
                public c.a.p0.a.u.c.b mSwanApiContext;

                /* loaded from: classes6.dex */
                public class a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ Throwable f45704e;

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
                        this.f45704e = th;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            throw this.f45704e;
                        }
                    }
                }

                /* loaded from: classes6.dex */
                public class b implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ Throwable f45705e;

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
                        this.f45705e = th;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            throw this.f45705e;
                        }
                    }
                }

                /* loaded from: classes6.dex */
                public class c implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ Throwable f45706e;

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
                        this.f45706e = th;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            throw this.f45706e;
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
                    DEBUG = d.f8735c;
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
                    c.a.p0.b.n.b bVar2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        try {
                            boolean z = DEBUG;
                            Object obj = this.mApis.get("-404108695");
                            if (obj != null && (obj instanceof c.a.p0.b.n.b)) {
                                bVar2 = (c.a.p0.b.n.b) obj;
                            } else {
                                bVar2 = new c.a.p0.b.n.b(this.mSwanApiContext);
                                this.mApis.put("-404108695", bVar2);
                            }
                            Pair<Boolean, c.a.p0.a.u.h.a> a2 = c.a.p0.a.u.i.a.a(bVar2, "swanAPI/getOpenBDUSS");
                            if (((Boolean) a2.first).booleanValue()) {
                                return ((c.a.p0.a.u.h.a) a2.second).a();
                            }
                            if (f.a(this.mSwanApiContext.g(), "PrivateBusiness.getOpenBDUSS")) {
                                return new c.a.p0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            }
                            c.a.p0.a.u.h.b s = bVar2.s(str);
                            String a3 = s == null ? "" : s.a();
                            if (DEBUG) {
                                String str2 = "====================[[PrivateBusiness.getOpenBDUSS[type:V8, v8 binding:false] result]]" + a3;
                            }
                            return a3;
                        } catch (Throwable th) {
                            if (DEBUG) {
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
                    c.a.p0.b.n.c cVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        try {
                            boolean z = DEBUG;
                            Object obj = this.mApis.get("1495818240");
                            if (obj != null && (obj instanceof c.a.p0.b.n.c)) {
                                cVar = (c.a.p0.b.n.c) obj;
                            } else {
                                cVar = new c.a.p0.b.n.c(this.mSwanApiContext);
                                this.mApis.put("1495818240", cVar);
                            }
                            Pair<Boolean, c.a.p0.a.u.h.a> a2 = c.a.p0.a.u.i.a.a(cVar, "swanAPI/queryQuickLoginInfo");
                            if (((Boolean) a2.first).booleanValue()) {
                                return ((c.a.p0.a.u.h.a) a2.second).a();
                            }
                            if (f.a(this.mSwanApiContext.g(), "PrivateBusiness.queryQuickLoginInfo")) {
                                return new c.a.p0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            }
                            c.a.p0.a.u.h.b z2 = cVar.z(str);
                            String a3 = z2 == null ? "" : z2.a();
                            if (DEBUG) {
                                String str2 = "====================[[PrivateBusiness.queryQuickLoginInfo[type:V8, v8 binding:false] result]]" + a3;
                            }
                            return a3;
                        } catch (Throwable th) {
                            if (DEBUG) {
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
                    c.a.p0.b.n.c cVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        try {
                            boolean z = DEBUG;
                            Object obj = this.mApis.get("1495818240");
                            if (obj != null && (obj instanceof c.a.p0.b.n.c)) {
                                cVar = (c.a.p0.b.n.c) obj;
                            } else {
                                cVar = new c.a.p0.b.n.c(this.mSwanApiContext);
                                this.mApis.put("1495818240", cVar);
                            }
                            Pair<Boolean, c.a.p0.a.u.h.a> a2 = c.a.p0.a.u.i.a.a(cVar, "swanAPI/quickLogin");
                            if (((Boolean) a2.first).booleanValue()) {
                                return ((c.a.p0.a.u.h.a) a2.second).a();
                            }
                            if (f.a(this.mSwanApiContext.g(), "PrivateBusiness.quickLogin")) {
                                return new c.a.p0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            }
                            c.a.p0.a.u.h.b A = cVar.A(str);
                            String a3 = A == null ? "" : A.a();
                            if (DEBUG) {
                                String str2 = "====================[[PrivateBusiness.quickLogin[type:V8, v8 binding:false] result]]" + a3;
                            }
                            return a3;
                        } catch (Throwable th) {
                            if (DEBUG) {
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

                /* loaded from: classes6.dex */
                public class a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ Throwable f45712e;

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
                        this.f45712e = th;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            throw this.f45712e;
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
                    DEBUG = d.f8735c;
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
                    c.a.p0.b.p.c.a aVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        try {
                            boolean z = DEBUG;
                            Object obj = this.mApis.get("-599878304");
                            if (obj != null && (obj instanceof c.a.p0.b.p.c.a)) {
                                aVar = (c.a.p0.b.p.c.a) obj;
                            } else {
                                aVar = new c.a.p0.b.p.c.a(this.mSwanApiContext);
                                this.mApis.put("-599878304", aVar);
                            }
                            Pair<Boolean, c.a.p0.a.u.h.a> a2 = c.a.p0.a.u.i.a.a(aVar, "swanAPI/getCommonSysInfo");
                            if (((Boolean) a2.first).booleanValue()) {
                                return ((c.a.p0.a.u.h.a) a2.second).a();
                            }
                            if (f.a(this.mSwanApiContext.g(), "PrivateUtils.getCommonSysInfo")) {
                                return new c.a.p0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            }
                            c.a.p0.a.u.h.b s = aVar.s(str);
                            String a3 = s == null ? "" : s.a();
                            if (DEBUG) {
                                String str2 = "====================[[PrivateUtils.getCommonSysInfo[type:V8, v8 binding:false] result]]" + a3;
                            }
                            return a3;
                        } catch (Throwable th) {
                            if (DEBUG) {
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

                /* loaded from: classes6.dex */
                public class a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ Throwable f45703e;

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
                        this.f45703e = th;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            throw this.f45703e;
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
                    DEBUG = d.f8735c;
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
                    c.a.p0.b.n.a aVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        try {
                            boolean z = DEBUG;
                            Object obj = this.mApis.get("446653951");
                            if (obj != null && (obj instanceof c.a.p0.b.n.a)) {
                                aVar = (c.a.p0.b.n.a) obj;
                            } else {
                                aVar = new c.a.p0.b.n.a(this.mSwanApiContext);
                                this.mApis.put("446653951", aVar);
                            }
                            Pair<Boolean, c.a.p0.a.u.h.a> a2 = c.a.p0.a.u.i.a.a(aVar, "swanAPI/getBDUSS");
                            if (((Boolean) a2.first).booleanValue()) {
                                return ((c.a.p0.a.u.h.a) a2.second).a();
                            }
                            if (f.a(this.mSwanApiContext.g(), "PrivateAccount.getBDUSS")) {
                                return new c.a.p0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            }
                            c.a.p0.a.u.h.b s = aVar.s(str);
                            String a3 = s == null ? "" : s.a();
                            if (DEBUG) {
                                String str2 = "====================[[PrivateAccount.getBDUSS[type:Webview, v8 binding:false] result]]" + a3;
                            }
                            return a3;
                        } catch (Throwable th) {
                            if (DEBUG) {
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
                public c.a.p0.a.u.c.b mSwanApiContext;

                /* loaded from: classes6.dex */
                public class a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ Throwable f45707e;

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
                        this.f45707e = th;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            throw this.f45707e;
                        }
                    }
                }

                /* loaded from: classes6.dex */
                public class b implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ Throwable f45708e;

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
                        this.f45708e = th;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            throw this.f45708e;
                        }
                    }
                }

                /* loaded from: classes6.dex */
                public class c implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ Throwable f45709e;

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
                        this.f45709e = th;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            throw this.f45709e;
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
                    DEBUG = d.f8735c;
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
                    c.a.p0.b.n.b bVar2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        try {
                            boolean z = DEBUG;
                            Object obj = this.mApis.get("-404108695");
                            if (obj != null && (obj instanceof c.a.p0.b.n.b)) {
                                bVar2 = (c.a.p0.b.n.b) obj;
                            } else {
                                bVar2 = new c.a.p0.b.n.b(this.mSwanApiContext);
                                this.mApis.put("-404108695", bVar2);
                            }
                            Pair<Boolean, c.a.p0.a.u.h.a> a2 = c.a.p0.a.u.i.a.a(bVar2, "swanAPI/getOpenBDUSS");
                            if (((Boolean) a2.first).booleanValue()) {
                                return ((c.a.p0.a.u.h.a) a2.second).a();
                            }
                            if (f.a(this.mSwanApiContext.g(), "PrivateBusiness.getOpenBDUSS")) {
                                return new c.a.p0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            }
                            c.a.p0.a.u.h.b s = bVar2.s(str);
                            String a3 = s == null ? "" : s.a();
                            if (DEBUG) {
                                String str2 = "====================[[PrivateBusiness.getOpenBDUSS[type:Webview, v8 binding:false] result]]" + a3;
                            }
                            return a3;
                        } catch (Throwable th) {
                            if (DEBUG) {
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
                    c.a.p0.b.n.c cVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                        try {
                            boolean z = DEBUG;
                            Object obj = this.mApis.get("1495818240");
                            if (obj != null && (obj instanceof c.a.p0.b.n.c)) {
                                cVar = (c.a.p0.b.n.c) obj;
                            } else {
                                cVar = new c.a.p0.b.n.c(this.mSwanApiContext);
                                this.mApis.put("1495818240", cVar);
                            }
                            Pair<Boolean, c.a.p0.a.u.h.a> a2 = c.a.p0.a.u.i.a.a(cVar, "swanAPI/queryQuickLoginInfo");
                            if (((Boolean) a2.first).booleanValue()) {
                                return ((c.a.p0.a.u.h.a) a2.second).a();
                            }
                            if (f.a(this.mSwanApiContext.g(), "PrivateBusiness.queryQuickLoginInfo")) {
                                return new c.a.p0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            }
                            c.a.p0.a.u.h.b z2 = cVar.z(str);
                            String a3 = z2 == null ? "" : z2.a();
                            if (DEBUG) {
                                String str2 = "====================[[PrivateBusiness.queryQuickLoginInfo[type:Webview, v8 binding:false] result]]" + a3;
                            }
                            return a3;
                        } catch (Throwable th) {
                            if (DEBUG) {
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
                    c.a.p0.b.n.c cVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                        try {
                            boolean z = DEBUG;
                            Object obj = this.mApis.get("1495818240");
                            if (obj != null && (obj instanceof c.a.p0.b.n.c)) {
                                cVar = (c.a.p0.b.n.c) obj;
                            } else {
                                cVar = new c.a.p0.b.n.c(this.mSwanApiContext);
                                this.mApis.put("1495818240", cVar);
                            }
                            Pair<Boolean, c.a.p0.a.u.h.a> a2 = c.a.p0.a.u.i.a.a(cVar, "swanAPI/quickLogin");
                            if (((Boolean) a2.first).booleanValue()) {
                                return ((c.a.p0.a.u.h.a) a2.second).a();
                            }
                            if (f.a(this.mSwanApiContext.g(), "PrivateBusiness.quickLogin")) {
                                return new c.a.p0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            }
                            c.a.p0.a.u.h.b A = cVar.A(str);
                            String a3 = A == null ? "" : A.a();
                            if (DEBUG) {
                                String str2 = "====================[[PrivateBusiness.quickLogin[type:Webview, v8 binding:false] result]]" + a3;
                            }
                            return a3;
                        } catch (Throwable th) {
                            if (DEBUG) {
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

                /* loaded from: classes6.dex */
                public class a implements Runnable {
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: e  reason: collision with root package name */
                    public final /* synthetic */ Throwable f45713e;

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
                        this.f45713e = th;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable = $ic;
                        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                            throw this.f45713e;
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
                    DEBUG = d.f8735c;
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
                    c.a.p0.b.p.c.a aVar;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, str)) == null) {
                        try {
                            boolean z = DEBUG;
                            Object obj = this.mApis.get("-599878304");
                            if (obj != null && (obj instanceof c.a.p0.b.p.c.a)) {
                                aVar = (c.a.p0.b.p.c.a) obj;
                            } else {
                                aVar = new c.a.p0.b.p.c.a(this.mSwanApiContext);
                                this.mApis.put("-599878304", aVar);
                            }
                            Pair<Boolean, c.a.p0.a.u.h.a> a2 = c.a.p0.a.u.i.a.a(aVar, "swanAPI/getCommonSysInfo");
                            if (((Boolean) a2.first).booleanValue()) {
                                return ((c.a.p0.a.u.h.a) a2.second).a();
                            }
                            if (f.a(this.mSwanApiContext.g(), "PrivateUtils.getCommonSysInfo")) {
                                return new c.a.p0.a.u.h.b(1001, "illegal swanApp, intercept for preload/prefetch").a();
                            }
                            c.a.p0.a.u.h.b s = aVar.s(str);
                            String a3 = s == null ? "" : s.a();
                            if (DEBUG) {
                                String str2 = "====================[[PrivateUtils.getCommonSysInfo[type:Webview, v8 binding:false] result]]" + a3;
                            }
                            return a3;
                        } catch (Throwable th) {
                            if (DEBUG) {
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
