package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class cl implements Thread.UncaughtExceptionHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "";
    public static final String b = "remote";
    public static final String c = "proxy";
    public static final String d = "third-mtj";
    public static final String e = "third-cpu";
    public static final String f = "third-cpu-cyber";
    public static final String g = "third-novel";
    public static final String h = "third-aigc";
    public static Thread.UncaughtExceptionHandler i = null;
    public static volatile cl j = null;
    public static final String m = "key_crash_source";
    public static final String n = "key_crash_trace";
    public static final String o = "key_crash_ad";
    public transient /* synthetic */ FieldHolder $fh;
    public Context k;
    public a l;

    /* loaded from: classes3.dex */
    public interface a {
        void a(String str);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1833694726, "Lcom/baidu/mobads/sdk/internal/cl;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1833694726, "Lcom/baidu/mobads/sdk/internal/cl;");
        }
    }

    public cl(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = context.getApplicationContext();
        i = Thread.getDefaultUncaughtExceptionHandler();
    }

    public static cl a(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            if (j == null) {
                synchronized (cl.class) {
                    if (j == null) {
                        j = new cl(context);
                    }
                }
            }
            return j;
        }
        return (cl) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) {
            return e().getString(str, "");
        }
        return (String) invokeL.objValue;
    }

    private String a(Throwable th) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, this, th)) == null) {
            Throwable cause = th.getCause();
            if (cause != null) {
                th = cause;
            }
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                List<String> d2 = d();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    String className = stackTraceElement.getClassName();
                    if (className.startsWith("junit.framework")) {
                        break;
                    }
                    if (!className.startsWith(w.au) && !className.startsWith(w.av) && !className.startsWith(w.aw)) {
                        if (!className.startsWith(w.ax) && !className.startsWith(w.ay) && !className.startsWith(w.az)) {
                            if (className.startsWith(w.aA)) {
                                return d;
                            }
                            if (className.startsWith(w.aB)) {
                                return e;
                            }
                            if (className.startsWith(w.aC) || className.startsWith(w.aD)) {
                                return f;
                            }
                            if (className.startsWith(w.aG)) {
                                return h;
                            }
                            if (!className.startsWith(w.aE) && !className.startsWith(w.aF)) {
                                if (a(className, d2)) {
                                }
                            } else if (ck.g.booleanValue()) {
                                return g;
                            }
                        } else {
                            return c;
                        }
                    }
                    return b;
                }
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    private boolean a(String str, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65543, this, str, list)) == null) {
            for (String str2 : list) {
                if (str.startsWith(str2)) {
                    return true;
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    private List<String> d() {
        InterceptResult invokeV;
        IXAdContainerFactory c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            ArrayList arrayList = new ArrayList();
            try {
                z a2 = z.a();
                if (a2 != null && (c2 = a2.c()) != null) {
                    Object remoteParam = c2.getRemoteParam("appCommonConfig", "getCrashPackage");
                    if (remoteParam instanceof List) {
                        arrayList.addAll((List) remoteParam);
                    }
                }
            } catch (Throwable unused) {
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    private SharedPreferences e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            return this.k.getSharedPreferences("baidu_mobads_crash", 0);
        }
        return (SharedPreferences) invokeV.objValue;
    }

    private SharedPreferences.Editor f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            return e().edit();
        }
        return (SharedPreferences.Editor) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65548, this) == null) {
            SharedPreferences.Editor f2 = f();
            f2.clear();
            f2.apply();
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ba.a().a((h) new cm(this));
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && !(Thread.getDefaultUncaughtExceptionHandler() instanceof cl)) {
            Thread.setDefaultUncaughtExceptionHandler(this);
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.l = null;
        }
    }

    public void a(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            this.l = aVar;
        }
    }

    public void a(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) {
            SharedPreferences.Editor f2 = f();
            f2.putString(m, str);
            f2.putString(n, ("crashtime:" + System.currentTimeMillis() + " ") + str2);
            f2.putString(o, a);
            f2.commit();
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, thread, th) == null) {
            try {
                String a2 = a(th);
                if (a2 != null) {
                    a(a2, Log.getStackTraceString(th));
                    if (this.l != null) {
                        this.l.a(a2);
                    }
                }
                if (i != null) {
                    i.uncaughtException(thread, th);
                }
            } catch (Exception e2) {
                br.a().c(e2);
            }
        }
    }
}
