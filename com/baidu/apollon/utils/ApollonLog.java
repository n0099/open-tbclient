package com.baidu.apollon.utils;

import android.os.SystemClock;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes9.dex */
public class ApollonLog {
    public static /* synthetic */ Interceptable $ic = null;
    public static boolean DEBUG = false;
    public static String TAG = "Apollon";
    public static final String a;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class MarkerLog {
        public static /* synthetic */ Interceptable $ic;
        public static final boolean ENABLED;
        public static final long a = 0;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: b  reason: collision with root package name */
        public final List<a> f33594b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f33595c;

        /* loaded from: classes9.dex */
        public static class a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final String a;

            /* renamed from: b  reason: collision with root package name */
            public final long f33596b;

            /* renamed from: c  reason: collision with root package name */
            public final long f33597c;

            public a(String str, long j2, long j3) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {str, Long.valueOf(j2), Long.valueOf(j3)};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = str;
                this.f33596b = j2;
                this.f33597c = j3;
            }
        }

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1332111276, "Lcom/baidu/apollon/utils/ApollonLog$MarkerLog;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1332111276, "Lcom/baidu/apollon/utils/ApollonLog$MarkerLog;");
                    return;
                }
            }
            ENABLED = ApollonLog.DEBUG;
        }

        public MarkerLog() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.f33594b = new ArrayList();
            this.f33595c = false;
        }

        private long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
                if (this.f33594b.size() == 0) {
                    return 0L;
                }
                long j2 = this.f33594b.get(0).f33597c;
                List<a> list = this.f33594b;
                return list.get(list.size() - 1).f33597c - j2;
            }
            return invokeV.longValue;
        }

        public synchronized void add(String str, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLJ(1048576, this, str, j2) == null) {
                synchronized (this) {
                    if (!this.f33595c) {
                        this.f33594b.add(new a(str, j2, SystemClock.elapsedRealtime()));
                    } else {
                        throw new IllegalStateException("Marker added to finished log");
                    }
                }
            }
        }

        public void finalize() throws Throwable {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || this.f33595c) {
                return;
            }
            finish("Request on the loose");
            ApollonLog.e("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }

        public synchronized void finish(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                synchronized (this) {
                    this.f33595c = true;
                    long a2 = a();
                    if (a2 <= 0) {
                        return;
                    }
                    long j2 = this.f33594b.get(0).f33597c;
                    ApollonLog.d("(%-4d ms) %s", Long.valueOf(a2), str);
                    for (a aVar : this.f33594b) {
                        long j3 = aVar.f33597c;
                        ApollonLog.d("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(aVar.f33596b), aVar.a);
                        j2 = j3;
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1291119418, "Lcom/baidu/apollon/utils/ApollonLog;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1291119418, "Lcom/baidu/apollon/utils/ApollonLog;");
                return;
            }
        }
        DEBUG = Log.isLoggable("Apollon", 2);
        a = ApollonLog.class.getName();
    }

    public ApollonLog() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String a(String str, Object... objArr) {
        InterceptResult invokeLL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, objArr)) == null) {
            if (objArr != null) {
                str = String.format(Locale.US, str, objArr);
            }
            StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
            int i2 = 2;
            while (true) {
                if (i2 >= stackTrace.length) {
                    str2 = "<unknown>";
                    break;
                } else if (!stackTrace[i2].getClassName().equals(a)) {
                    String className = stackTrace[i2].getClassName();
                    String substring = className.substring(className.lastIndexOf(46) + 1);
                    str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i2].getMethodName();
                    break;
                } else {
                    i2++;
                }
            }
            return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
        }
        return (String) invokeLL.objValue;
    }

    public static void d(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, str, objArr) == null) {
            a(str, objArr);
        }
    }

    public static void e(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, str, objArr) == null) {
            a(str, objArr);
        }
    }

    public static void setTag(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, str) == null) {
            d("Changing log tag to %s", str);
            TAG = str;
            DEBUG = Log.isLoggable(str, 2);
        }
    }

    public static void v(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65543, null, str, objArr) == null) && DEBUG) {
            a(str, objArr);
        }
    }

    public static void wtf(String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, str, objArr) == null) {
            Log.wtf(TAG, a(str, objArr));
        }
    }

    public static void e(Throwable th, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65541, null, th, str, objArr) == null) {
            a(str, objArr);
        }
    }

    public static void wtf(Throwable th, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65545, null, th, str, objArr) == null) {
            Log.wtf(TAG, a(str, objArr), th);
        }
    }
}
