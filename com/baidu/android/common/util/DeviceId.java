package com.baidu.android.common.util;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import b.a.m.e;
import b.a.m.f;
import b.a.m.g;
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
/* loaded from: classes6.dex */
public final class DeviceId {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: f  reason: collision with root package name */
    public static final String f35628f = "DeviceId";

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f35629g = false;

    /* renamed from: h  reason: collision with root package name */
    public static g.a f35630h = null;

    /* renamed from: i  reason: collision with root package name */
    public static volatile DeviceId f35631i = null;
    public static CuidChangeCallback j = null;
    public static boolean sDataCuidInfoShable = true;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Context f35632a;

    /* renamed from: b  reason: collision with root package name */
    public g f35633b;

    /* renamed from: c  reason: collision with root package name */
    public f f35634c;

    /* renamed from: d  reason: collision with root package name */
    public b.a.m.c f35635d;

    /* renamed from: e  reason: collision with root package name */
    public Executor f35636e;

    /* loaded from: classes6.dex */
    public interface CuidChangeCallback {
        void onCuidChanged(String str, String str2, CuidChangeReceivedCallback cuidChangeReceivedCallback);
    }

    /* loaded from: classes6.dex */
    public interface CuidChangeReceivedCallback {
        void onCuidChangeReceived();
    }

    /* loaded from: classes6.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g.a f35637a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DeviceId f35638b;

        /* renamed from: com.baidu.android.common.util.DeviceId$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C1573a implements CuidChangeReceivedCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ a f35639a;

            public C1573a(a aVar) {
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
                this.f35639a = aVar;
            }

            @Override // com.baidu.android.common.util.DeviceId.CuidChangeReceivedCallback
            public void onCuidChangeReceived() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    a aVar = this.f35639a;
                    aVar.f35638b.d(aVar.f35637a);
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
            this.f35638b = deviceId;
            this.f35637a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || DeviceId.j == null) {
                return;
            }
            g.a aVar = this.f35637a;
            if (aVar == null || aVar.w() || TextUtils.isEmpty(this.f35637a.t())) {
                CuidChangeCallback unused = DeviceId.j = null;
            } else {
                DeviceId.j.onCuidChanged(this.f35637a.r(), this.f35637a.t(), new C1573a(this));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g.a f35640a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DeviceId f35641b;

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
            this.f35641b = deviceId;
            this.f35640a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (e.class) {
                    if (DeviceId.j == null) {
                        return;
                    }
                    this.f35641b.f35633b.i();
                    this.f35640a.g(true);
                    this.f35641b.f35633b.j(this.f35640a, true, true);
                    CuidChangeCallback unused = DeviceId.j = null;
                    this.f35641b.f35633b.p();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g.a f35642a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DeviceId f35643b;

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
            this.f35643b = deviceId;
            this.f35642a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.f35643b.c(this.f35642a);
                } finally {
                    this.f35643b.f35633b.p();
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
        this.f35636e = new ThreadPoolExecutor(0, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f35632a = context.getApplicationContext();
        this.f35635d = new b.a.m.c();
        this.f35633b = new g(this.f35632a, new b.a.m.l.a(this.f35632a), this.f35635d);
        this.f35634c = new f(this.f35632a, this.f35635d);
    }

    private g.a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) ? this.f35633b.m(str) : (g.a) invokeL.objValue;
    }

    private g.a a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, str2)) == null) {
            e g2 = this.f35634c.g(str);
            if (g2 == null || TextUtils.equals(str2, g2.f3406a)) {
                return null;
            }
            return this.f35633b.a(g2);
        }
        return (g.a) invokeLL.objValue;
    }

    public static DeviceId a(Context context) {
        InterceptResult invokeL;
        DeviceId deviceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            synchronized (e.class) {
                if (f35631i == null) {
                    f35631i = new DeviceId(context);
                }
                deviceId = f35631i;
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
            this.f35633b.i();
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
                this.f35633b.p();
                throw th;
            }
        }
        return (g.a) invokeV.objValue;
    }

    public static g.a b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            if (f35630h == null) {
                synchronized (e.class) {
                    if (f35630h == null) {
                        SystemClock.uptimeMillis();
                        f35630h = a(context).b();
                        SystemClock.uptimeMillis();
                    }
                }
            }
            a(context).d();
            return f35630h;
        }
        return (g.a) invokeL.objValue;
    }

    private g.a b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, str, str2)) == null) {
            g.a o = this.f35633b.o(str2);
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
            this.f35633b.j(aVar, true, false);
            this.f35634c.c(y);
            this.f35633b.g(aVar);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            g.a aVar = f35630h;
            if (j == null) {
                return;
            }
            if (aVar == null || aVar.w() || TextUtils.isEmpty(aVar.t())) {
                j = null;
            } else {
                this.f35636e.execute(new a(this, aVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(g.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, aVar) == null) {
            this.f35636e.execute(new b(this, aVar));
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
                this.f35636e.execute(a(aVar));
            }
        }
    }

    private g.a f() {
        InterceptResult invokeV;
        e a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            File file = new File(this.f35632a.getFilesDir(), "libcuid.so");
            if (!file.exists() || (a2 = e.a(b.a.m.m.c.a(file))) == null) {
                return null;
            }
            return this.f35633b.a(a2);
        }
        return (g.a) invokeV.objValue;
    }

    private g.a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) ? this.f35633b.k() : (g.a) invokeV.objValue;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) ? a(context).f35635d.d(context.getApplicationContext()) : invokeL.booleanValue;
    }

    public static void registerCuidChangeEvent(Context context, CuidChangeCallback cuidChangeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65562, null, context, cuidChangeCallback) == null) {
            j = cuidChangeCallback;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f35633b : (g) invokeV.objValue;
    }
}
