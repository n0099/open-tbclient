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
    public static final String f32566f = "DeviceId";

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f32567g = false;

    /* renamed from: h  reason: collision with root package name */
    public static g.a f32568h = null;

    /* renamed from: i  reason: collision with root package name */
    public static volatile DeviceId f32569i = null;

    /* renamed from: j  reason: collision with root package name */
    public static CuidChangeCallback f32570j = null;
    public static boolean sDataCuidInfoShable = true;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;

    /* renamed from: b  reason: collision with root package name */
    public g f32571b;

    /* renamed from: c  reason: collision with root package name */
    public f f32572c;

    /* renamed from: d  reason: collision with root package name */
    public c.a.m.c f32573d;

    /* renamed from: e  reason: collision with root package name */
    public Executor f32574e;

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
        public final /* synthetic */ DeviceId f32575b;

        /* renamed from: com.baidu.android.common.util.DeviceId$a$a  reason: collision with other inner class name */
        /* loaded from: classes9.dex */
        public class C1696a implements CuidChangeReceivedCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C1696a(a aVar) {
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
                    aVar.f32575b.d(aVar.a);
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
            this.f32575b = deviceId;
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || DeviceId.f32570j == null) {
                return;
            }
            g.a aVar = this.a;
            if (aVar == null || aVar.w() || TextUtils.isEmpty(this.a.t())) {
                CuidChangeCallback unused = DeviceId.f32570j = null;
            } else {
                DeviceId.f32570j.onCuidChanged(this.a.r(), this.a.t(), new C1696a(this));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g.a a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DeviceId f32576b;

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
            this.f32576b = deviceId;
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (e.class) {
                    if (DeviceId.f32570j == null) {
                        return;
                    }
                    this.f32576b.f32571b.i();
                    this.a.g(true);
                    this.f32576b.f32571b.j(this.a, true, true);
                    CuidChangeCallback unused = DeviceId.f32570j = null;
                    this.f32576b.f32571b.p();
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
        public final /* synthetic */ DeviceId f32577b;

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
            this.f32577b = deviceId;
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f32577b.c(this.a);
                } finally {
                    this.f32577b.f32571b.p();
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
        this.f32574e = new ThreadPoolExecutor(0, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.a = context.getApplicationContext();
        this.f32573d = new c.a.m.c();
        this.f32571b = new g(this.a, new c.a.m.l.a(this.a), this.f32573d);
        this.f32572c = new f(this.a, this.f32573d);
    }

    private g.a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) ? this.f32571b.m(str) : (g.a) invokeL.objValue;
    }

    private g.a a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, str2)) == null) {
            e g2 = this.f32572c.g(str);
            if (g2 == null || TextUtils.equals(str2, g2.a)) {
                return null;
            }
            return this.f32571b.a(g2);
        }
        return (g.a) invokeLL.objValue;
    }

    public static DeviceId a(Context context) {
        InterceptResult invokeL;
        DeviceId deviceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            synchronized (e.class) {
                if (f32569i == null) {
                    f32569i = new DeviceId(context);
                }
                deviceId = f32569i;
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
            this.f32571b.i();
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
                this.f32571b.p();
                throw th;
            }
        }
        return (g.a) invokeV.objValue;
    }

    public static g.a b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            if (f32568h == null) {
                synchronized (e.class) {
                    if (f32568h == null) {
                        SystemClock.uptimeMillis();
                        f32568h = a(context).b();
                        SystemClock.uptimeMillis();
                    }
                }
            }
            a(context).d();
            return f32568h;
        }
        return (g.a) invokeL.objValue;
    }

    private g.a b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, str, str2)) == null) {
            g.a o = this.f32571b.o(str2);
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
            this.f32571b.j(aVar, true, false);
            this.f32572c.c(y);
            this.f32571b.g(aVar);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            g.a aVar = f32568h;
            if (f32570j == null) {
                return;
            }
            if (aVar == null || aVar.w() || TextUtils.isEmpty(aVar.t())) {
                f32570j = null;
            } else {
                this.f32574e.execute(new a(this, aVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, aVar) == null) {
            this.f32574e.execute(new b(this, aVar));
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
                this.f32574e.execute(a(aVar));
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
            return this.f32571b.a(a2);
        }
        return (g.a) invokeV.objValue;
    }

    private g.a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) ? this.f32571b.k() : (g.a) invokeV.objValue;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) ? a(context).f32573d.d(context.getApplicationContext()) : invokeL.booleanValue;
    }

    public static void registerCuidChangeEvent(Context context, CuidChangeCallback cuidChangeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65562, null, context, cuidChangeCallback) == null) {
            f32570j = cuidChangeCallback;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f32571b : (g) invokeV.objValue;
    }
}
