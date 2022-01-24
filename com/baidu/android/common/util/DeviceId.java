package com.baidu.android.common.util;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import c.a.m.e;
import c.a.m.f;
import c.a.m.g;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes9.dex */
public final class DeviceId {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: f  reason: collision with root package name */
    public static final String f31557f = "DeviceId";

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f31558g = false;

    /* renamed from: h  reason: collision with root package name */
    public static g.a f31559h = null;

    /* renamed from: i  reason: collision with root package name */
    public static volatile DeviceId f31560i = null;

    /* renamed from: j  reason: collision with root package name */
    public static CuidChangeCallback f31561j = null;
    public static boolean sDataCuidInfoShable = true;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public g f31562b;

    /* renamed from: c  reason: collision with root package name */
    public f f31563c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.m.c f31564d;

    /* renamed from: e  reason: collision with root package name */
    public Executor f31565e;

    /* loaded from: classes9.dex */
    public interface CuidChangeCallback {
        void onCuidChanged(String str, String str2, CuidChangeReceivedCallback cuidChangeReceivedCallback);
    }

    /* loaded from: classes9.dex */
    public interface CuidChangeReceivedCallback {
        void onCuidChangeReceived();
    }

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DeviceId f31566b;

        /* renamed from: com.baidu.android.common.util.DeviceId$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1713a implements CuidChangeReceivedCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C1713a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // com.baidu.android.common.util.DeviceId.CuidChangeReceivedCallback
            public void onCuidChangeReceived() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.a;
                    aVar.f31566b.d(aVar.a);
                }
            }
        }

        public a(DeviceId deviceId, g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {deviceId, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31566b = deviceId;
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || DeviceId.f31561j == null) {
                return;
            }
            g.a aVar = this.a;
            if (aVar == null || aVar.w() || TextUtils.isEmpty(this.a.t())) {
                CuidChangeCallback unused = DeviceId.f31561j = null;
            } else {
                DeviceId.f31561j.onCuidChanged(this.a.r(), this.a.t(), new C1713a(this));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DeviceId f31567b;

        public b(DeviceId deviceId, g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {deviceId, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31567b = deviceId;
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (e.class) {
                    if (DeviceId.f31561j == null) {
                        return;
                    }
                    this.f31567b.f31562b.i();
                    this.a.g(true);
                    this.f31567b.f31562b.j(this.a, true, true);
                    CuidChangeCallback unused = DeviceId.f31561j = null;
                    this.f31567b.f31562b.p();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DeviceId f31568b;

        public c(DeviceId deviceId, g.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {deviceId, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31568b = deviceId;
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f31568b.c(this.a);
                } finally {
                    this.f31568b.f31562b.p();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-893770989, "Lcom/baidu/android/common/util/DeviceId;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-893770989, "Lcom/baidu/android/common/util/DeviceId;");
        }
    }

    public DeviceId(Context context) {
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
        this.f31565e = new ThreadPoolExecutor(0, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.a = context.getApplicationContext();
        this.f31564d = new c.a.m.c();
        this.f31562b = new g(this.a, new c.a.m.l.a(this.a), this.f31564d);
        this.f31563c = new f(this.a, this.f31564d);
    }

    private g.a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) ? this.f31562b.m(str) : (g.a) invokeL.objValue;
    }

    private g.a a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, str2)) == null) {
            e g2 = this.f31563c.g(str);
            if (g2 == null || TextUtils.equals(str2, g2.a)) {
                return null;
            }
            return this.f31562b.a(g2);
        }
        return (g.a) invokeLL.objValue;
    }

    public static DeviceId a(Context context) {
        InterceptResult invokeL;
        DeviceId deviceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            synchronized (e.class) {
                if (f31560i == null) {
                    f31560i = new DeviceId(context);
                }
                deviceId = f31560i;
            }
            return deviceId;
        }
        return (DeviceId) invokeL.objValue;
    }

    private Runnable a(g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, this, aVar)) == null) ? new c(this, aVar) : (Runnable) invokeL.objValue;
    }

    private g.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            this.f31562b.i();
            try {
                g.a e2 = e();
                if (!b(e2)) {
                    if (e2 == null) {
                        e2 = b((String) null, (String) null);
                    }
                    if (e2 == null) {
                        e2 = a((String) null);
                    }
                    e(e2);
                    return e2;
                }
                g.a b2 = b((String) null, e2.n());
                if (b2 == null) {
                    b2 = a((String) null);
                }
                b2.g(false);
                b2.f(e2.r());
                e(b2);
                return b2;
            } catch (Throwable th) {
                this.f31562b.p();
                throw th;
            }
        }
        return (g.a) invokeV.objValue;
    }

    public static g.a b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            if (f31559h == null) {
                synchronized (e.class) {
                    if (f31559h == null) {
                        SystemClock.uptimeMillis();
                        f31559h = a(context).b();
                        SystemClock.uptimeMillis();
                    }
                }
            }
            a(context).d();
            return f31559h;
        }
        return (g.a) invokeL.objValue;
    }

    private g.a b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, str, str2)) == null) {
            g.a o = this.f31562b.o(str2);
            return o == null ? a(str, str2) : o;
        }
        return (g.a) invokeLL.objValue;
    }

    private boolean b(g.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, this, aVar)) == null) ? (aVar == null || !aVar.m() || TextUtils.isEmpty(aVar.u()) || TextUtils.equals(aVar.u(), g.n())) ? false : true : invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, aVar) == null) {
            if (aVar == null) {
                throw new NullPointerException("cuidV270Info should not be null");
            }
            e y = aVar.y();
            if (!aVar.m() || TextUtils.isEmpty(aVar.u())) {
                aVar.e();
            }
            this.f31562b.j(aVar, true, false);
            this.f31563c.c(y);
            this.f31562b.g(aVar);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            g.a aVar = f31559h;
            if (f31561j == null) {
                return;
            }
            if (aVar == null || aVar.w() || TextUtils.isEmpty(aVar.t())) {
                f31561j = null;
            } else {
                this.f31565e.execute(new a(this, aVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, aVar) == null) {
            this.f31565e.execute(new b(this, aVar));
        }
    }

    private g.a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            g.a g2 = g();
            return g2 == null ? f() : g2;
        }
        return (g.a) invokeV.objValue;
    }

    private synchronized void e(g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, aVar) == null) {
            synchronized (this) {
                this.f31565e.execute(a(aVar));
            }
        }
    }

    private g.a f() {
        InterceptResult invokeV;
        e a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            File file = new File(this.a.getFilesDir(), "libcuid.so");
            if (!file.exists() || (a2 = e.a(c.a.m.m.c.a(file))) == null) {
                return null;
            }
            return this.f31562b.a(a2);
        }
        return (g.a) invokeV.objValue;
    }

    private g.a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) ? this.f31562b.k() : (g.a) invokeV.objValue;
    }

    public static String getCUID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) ? b(context).r() : (String) invokeL.objValue;
    }

    public static String getDeviceID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) ? b(context).n() : (String) invokeL.objValue;
    }

    public static String getOldCUID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) ? b(context).t() : (String) invokeL.objValue;
    }

    public static boolean isMySelfTrusted(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) ? a(context).f31564d.d(context.getApplicationContext()) : invokeL.booleanValue;
    }

    public static void registerCuidChangeEvent(Context context, CuidChangeCallback cuidChangeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65562, null, context, cuidChangeCallback) == null) {
            f31561j = cuidChangeCallback;
            b(context);
        }
    }

    @Deprecated
    public static void setCuidDataShable(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65563, null, context, z) == null) {
        }
    }

    public g c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f31562b : (g) invokeV.objValue;
    }
}
