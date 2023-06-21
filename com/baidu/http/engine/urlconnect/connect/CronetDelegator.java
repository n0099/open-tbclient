package com.baidu.http.engine.urlconnect.connect;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.network.support.dns.Dns;
import com.baidu.tieba.q70;
import com.baidu.tieba.t70;
import com.baidu.tieba.u70;
import com.baidu.tieba.z70;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public class CronetDelegator implements z70 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Object a;
    public Method b;
    public Method c;
    public Class d;
    public int e;
    public t70 f;
    public Context g;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public class b implements InvocationHandler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CronetDelegator a;

        /* loaded from: classes3.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ q70 a;
            public final /* synthetic */ u70 b;

            public a(b bVar, q70 q70Var, u70 u70Var) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {bVar, q70Var, u70Var};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = q70Var;
                this.b = u70Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                q70 q70Var;
                Interceptable interceptable = $ic;
                if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && (q70Var = this.a) != null) {
                    q70Var.b(this.b.b());
                }
            }
        }

        public b(CronetDelegator cronetDelegator) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cronetDelegator};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cronetDelegator;
        }

        public /* synthetic */ b(CronetDelegator cronetDelegator, a aVar) {
            this(cronetDelegator);
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            InterceptResult invokeLLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, obj, method, objArr)) == null) {
                String name = method.getName();
                List<InetAddress> list = null;
                if ("resolve".equalsIgnoreCase(name)) {
                    String str = (String) objArr[0];
                    Dns q = this.a.f.q();
                    if (q != null) {
                        try {
                            list = q.lookup(str);
                        } catch (UnknownHostException e) {
                            e.printStackTrace();
                        }
                    }
                    if (list == null) {
                        return new ArrayList();
                    }
                    return list;
                }
                if ("onRTTOrThroughputEstimatesComputed".equalsIgnoreCase(name)) {
                    int intValue = ((Integer) objArr[0]).intValue();
                    ((Integer) objArr[1]).intValue();
                    ((Integer) objArr[2]).intValue();
                    int intValue2 = ((Integer) this.a.c.invoke(this.a.a, new Object[0])).intValue();
                    u70 a2 = u70.a();
                    if (intValue2 == 0) {
                        a2.d(-1);
                    } else if (intValue2 == 1) {
                        a2.d(3);
                    } else if (intValue2 != 2 && intValue2 != 3 && intValue <= 1000.0d) {
                        a2.d(1);
                    } else {
                        a2.d(2);
                    }
                    if (this.a.e != intValue2) {
                        for (q70 q70Var : a2.c()) {
                            try {
                                q70Var.a().execute(new a(this, q70Var, a2));
                            } catch (Exception e2) {
                                Log.e("CronetDelegator", "Exception posting task to executor", e2);
                            }
                        }
                        this.a.e = intValue2;
                    }
                }
                if (!"getExecutor".equalsIgnoreCase(name)) {
                    return null;
                }
                return Executors.newCachedThreadPool();
            }
            return invokeLLL.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class AppState {
        public static final /* synthetic */ AppState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final AppState APP_STATE_BACKGROUND;
        public static final AppState APP_STATE_FOREGROUND;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-44111928, "Lcom/baidu/http/engine/urlconnect/connect/CronetDelegator$AppState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-44111928, "Lcom/baidu/http/engine/urlconnect/connect/CronetDelegator$AppState;");
                    return;
                }
            }
            APP_STATE_BACKGROUND = new AppState("APP_STATE_BACKGROUND", 0);
            AppState appState = new AppState("APP_STATE_FOREGROUND", 1);
            APP_STATE_FOREGROUND = appState;
            $VALUES = new AppState[]{APP_STATE_BACKGROUND, appState};
        }

        public AppState(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static AppState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (AppState) Enum.valueOf(AppState.class, str);
            }
            return (AppState) invokeL.objValue;
        }

        public static AppState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (AppState[]) $VALUES.clone();
            }
            return (AppState[]) invokeV.objValue;
        }
    }

    public CronetDelegator(Context context, t70 t70Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, t70Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = -1;
        this.f = t70Var;
        this.g = context;
    }

    public static ClassLoader f(Context context) throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, context)) == null) {
            Class<?> cls = Class.forName("com.baidu.webkit.sdk.WebViewFactory");
            return cls.getDeclaredMethod("getProvider", new Class[0]).invoke(cls, new Object[0]).getClass().getClassLoader();
        }
        return (ClassLoader) invokeL.objValue;
    }

    @Override // com.baidu.tieba.z70
    public HttpURLConnection openHttpURLConnection(URL url) throws IOException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, url)) == null) {
            try {
                if (this.a == null) {
                    g();
                }
                if (this.b != null && this.a != null) {
                    return (HttpURLConnection) this.b.invoke(this.a, url);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
            }
            return (HttpURLConnection) url.openConnection();
        }
        return (HttpURLConnection) invokeL.objValue;
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            try {
                ClassLoader f = f(this.g);
                Class<?> cls = Class.forName("org.chromium.net.CronetEngine$Builder", true, f);
                Object newInstance = cls.getDeclaredConstructor(Context.class).newInstance(this.g);
                if (this.f.v()) {
                    try {
                        newInstance = newInstance.getClass().getDeclaredMethod("addPreconnPrefixes", String.class).invoke(newInstance.getClass().getDeclaredMethod("enablePreconn", Boolean.TYPE).invoke(newInstance, Boolean.TRUE), "https://mbd.baidu.com|2");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (this.f.u()) {
                    newInstance = newInstance.getClass().getDeclaredMethod("enableNetworkQualityEstimator", Boolean.TYPE).invoke(newInstance, Boolean.TRUE);
                }
                b bVar = new b(this, null);
                try {
                    Class<?> cls2 = Class.forName("org.chromium.net.HostResolver", true, f);
                    newInstance = newInstance.getClass().getDeclaredMethod("setHostResolver", cls2).invoke(newInstance, Proxy.newProxyInstance(f, new Class[]{cls2}, bVar));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                String packageName = this.g.getPackageName();
                if (!TextUtils.isEmpty(packageName)) {
                    try {
                        cls.getDeclaredMethod("setAppPackageName", String.class).invoke(newInstance, packageName);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
                this.a = cls.getDeclaredMethod("build", new Class[0]).invoke(newInstance, new Object[0]);
                Class<?> cls3 = Class.forName("org.chromium.net.CronetEngine", true, f);
                if (this.f.u()) {
                    Class<?> cls4 = Class.forName("org.chromium.net.NetworkQualityRttListener", true, f);
                    Class<?> cls5 = Class.forName("org.chromium.net.NetworkQualityThroughputListener", true, f);
                    Method declaredMethod = cls3.getDeclaredMethod("addRttListener", cls4);
                    Method declaredMethod2 = cls3.getDeclaredMethod("addThroughputListener", cls5);
                    this.c = cls3.getDeclaredMethod("getEffectiveConnectionType", new Class[0]);
                    declaredMethod.invoke(this.a, Proxy.newProxyInstance(f, new Class[]{cls4}, bVar));
                    declaredMethod2.invoke(this.a, Proxy.newProxyInstance(f, new Class[]{cls5}, bVar));
                }
                this.b = cls3.getDeclaredMethod("openConnection", URL.class);
                Class<?> cls6 = Class.forName("org.chromium.net.CronetEngine$AppState", true, f);
                this.d = cls6;
                cls3.getDeclaredMethod("notifyBdAppStatusChange", cls6);
            } catch (ClassNotFoundException e4) {
                e4.printStackTrace();
            } catch (IllegalAccessException e5) {
                e5.printStackTrace();
            } catch (InstantiationException e6) {
                e6.printStackTrace();
            } catch (NoSuchMethodException e7) {
                e7.printStackTrace();
            } catch (InvocationTargetException e8) {
                e8.printStackTrace();
            }
        }
    }
}
