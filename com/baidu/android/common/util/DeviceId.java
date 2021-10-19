package com.baidu.android.common.util;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import c.a.m.f;
import c.a.m.g.a;
import c.a.m.i.c;
import c.a.m.j;
import c.a.m.k;
import c.a.m.l;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes4.dex */
public final class DeviceId {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f36747a = "DeviceId";

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f36748b = false;

    /* renamed from: d  reason: collision with root package name */
    public static l.a f36749d = null;

    /* renamed from: g  reason: collision with root package name */
    public static volatile DeviceId f36750g = null;

    /* renamed from: i  reason: collision with root package name */
    public static CuidChangeCallback f36751i = null;
    public static boolean sDataCuidInfoShable = true;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final Context f36752c;

    /* renamed from: e  reason: collision with root package name */
    public l f36753e;

    /* renamed from: f  reason: collision with root package name */
    public k f36754f;

    /* renamed from: h  reason: collision with root package name */
    public f f36755h;

    /* renamed from: j  reason: collision with root package name */
    public Executor f36756j;

    /* loaded from: classes4.dex */
    public interface CuidChangeCallback {
        void onCuidChanged(String str, String str2, CuidChangeReceivedCallback cuidChangeReceivedCallback);
    }

    /* loaded from: classes4.dex */
    public interface CuidChangeReceivedCallback {
        void onCuidChangeReceived();
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
        this.f36756j = new ThreadPoolExecutor(0, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f36752c = context.getApplicationContext();
        this.f36755h = new f();
        this.f36753e = new l(this.f36752c, new a(this.f36752c), this.f36755h);
        this.f36754f = new k(this.f36752c, this.f36755h);
    }

    private l.a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) ? this.f36753e.k(str) : (l.a) invokeL.objValue;
    }

    private l.a a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, str2)) == null) {
            l.a m = this.f36753e.m(str2);
            return m == null ? b(str, str2) : m;
        }
        return (l.a) invokeLL.objValue;
    }

    public static DeviceId a(Context context) {
        InterceptResult invokeL;
        DeviceId deviceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context)) == null) {
            synchronized (j.class) {
                if (f36750g == null) {
                    f36750g = new DeviceId(context);
                }
                deviceId = f36750g;
            }
            return deviceId;
        }
        return (DeviceId) invokeL.objValue;
    }

    private boolean a(l.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, this, aVar)) == null) ? (aVar == null || !aVar.q() || TextUtils.isEmpty(aVar.r()) || TextUtils.equals(aVar.r(), l.l())) ? false : true : invokeL.booleanValue;
    }

    public static l.a b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, context)) == null) {
            if (f36749d == null) {
                synchronized (j.class) {
                    if (f36749d == null) {
                        SystemClock.uptimeMillis();
                        f36749d = a(context).c();
                        SystemClock.uptimeMillis();
                    }
                }
            }
            a(context).d();
            return f36749d;
        }
        return (l.a) invokeL.objValue;
    }

    private l.a b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, this, str, str2)) == null) {
            j b2 = this.f36754f.b(str);
            if (b2 == null || TextUtils.equals(str2, b2.f4043a)) {
                return null;
            }
            return this.f36753e.b(b2);
        }
        return (l.a) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, aVar) == null) {
            this.f36756j.execute(new Runnable(this, aVar) { // from class: com.baidu.android.common.util.DeviceId.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l.a f36760a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ DeviceId f36761b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, aVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f36761b = this;
                    this.f36760a = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (j.class) {
                            if (DeviceId.f36751i == null) {
                                return;
                            }
                            this.f36761b.f36753e.n();
                            this.f36760a.f(true);
                            this.f36761b.f36753e.j(this.f36760a, true, true);
                            CuidChangeCallback unused = DeviceId.f36751i = null;
                            this.f36761b.f36753e.p();
                        }
                    }
                }
            });
        }
    }

    private l.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            this.f36753e.n();
            try {
                l.a e2 = e();
                if (!a(e2)) {
                    if (e2 == null) {
                        e2 = a((String) null, (String) null);
                    }
                    if (e2 == null) {
                        e2 = a((String) null);
                    }
                    c(e2);
                    return e2;
                }
                l.a a2 = a((String) null, e2.h());
                if (a2 == null) {
                    a2 = a((String) null);
                }
                a2.f(false);
                a2.e(e2.y());
                c(a2);
                return a2;
            } catch (Throwable th) {
                this.f36753e.p();
                throw th;
            }
        }
        return (l.a) invokeV.objValue;
    }

    private synchronized void c(l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, aVar) == null) {
            synchronized (this) {
                this.f36756j.execute(d(aVar));
            }
        }
    }

    private Runnable d(l.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, this, aVar)) == null) ? new Runnable(this, aVar) { // from class: com.baidu.android.common.util.DeviceId.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ l.a f36762a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ DeviceId f36763b;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, aVar};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f36763b = this;
                this.f36762a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        this.f36763b.e(this.f36762a);
                    } finally {
                        this.f36763b.f36753e.p();
                    }
                }
            }
        } : (Runnable) invokeL.objValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            l.a aVar = f36749d;
            if (f36751i == null) {
                return;
            }
            if (aVar == null || aVar.t() || TextUtils.isEmpty(aVar.u())) {
                f36751i = null;
            } else {
                this.f36756j.execute(new Runnable(this, aVar) { // from class: com.baidu.android.common.util.DeviceId.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ l.a f36757a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ DeviceId f36758b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, aVar};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f36758b = this;
                        this.f36757a = aVar;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || DeviceId.f36751i == null) {
                            return;
                        }
                        l.a aVar2 = this.f36757a;
                        if (aVar2 == null || aVar2.t() || TextUtils.isEmpty(this.f36757a.u())) {
                            CuidChangeCallback unused = DeviceId.f36751i = null;
                        } else {
                            DeviceId.f36751i.onCuidChanged(this.f36757a.y(), this.f36757a.u(), new CuidChangeReceivedCallback(this) { // from class: com.baidu.android.common.util.DeviceId.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass1 f36759a;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.f36759a = this;
                                }

                                @Override // com.baidu.android.common.util.DeviceId.CuidChangeReceivedCallback
                                public void onCuidChangeReceived() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        AnonymousClass1 anonymousClass1 = this.f36759a;
                                        anonymousClass1.f36758b.b(anonymousClass1.f36757a);
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    private l.a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            l.a f2 = f();
            return f2 == null ? g() : f2;
        }
        return (l.a) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, aVar) == null) {
            if (aVar == null) {
                throw new NullPointerException("cuidV270Info should not be null");
            }
            j w = aVar.w();
            if (!aVar.q() || TextUtils.isEmpty(aVar.r())) {
                aVar.v();
            }
            this.f36753e.j(aVar, true, false);
            this.f36754f.c(w);
            this.f36753e.i(aVar);
        }
    }

    private l.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) ? this.f36753e.a() : (l.a) invokeV.objValue;
    }

    private l.a g() {
        InterceptResult invokeV;
        j e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            File file = new File(this.f36752c.getFilesDir(), "libcuid.so");
            if (!file.exists() || (e2 = j.e(c.a(file))) == null) {
                return null;
            }
            return this.f36753e.b(e2);
        }
        return (l.a) invokeV.objValue;
    }

    public static String getCUID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) ? b(context).y() : (String) invokeL.objValue;
    }

    public static String getDeviceID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) ? b(context).h() : (String) invokeL.objValue;
    }

    public static String getOldCUID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) ? b(context).u() : (String) invokeL.objValue;
    }

    public static boolean isMySelfTrusted(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) ? a(context).f36755h.d(context.getApplicationContext()) : invokeL.booleanValue;
    }

    public static void registerCuidChangeEvent(Context context, CuidChangeCallback cuidChangeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65562, null, context, cuidChangeCallback) == null) {
            f36751i = cuidChangeCallback;
            b(context);
        }
    }

    @Deprecated
    public static void setCuidDataShable(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65563, null, context, z) == null) {
        }
    }

    public l a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f36753e : (l) invokeV.objValue;
    }
}
