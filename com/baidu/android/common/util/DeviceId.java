package com.baidu.android.common.util;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import b.a.m.f;
import b.a.m.g.a;
import b.a.m.i.c;
import b.a.m.j;
import b.a.m.k;
import b.a.m.l;
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
/* loaded from: classes6.dex */
public final class DeviceId {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f34799a = "DeviceId";

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f34800b = false;

    /* renamed from: d  reason: collision with root package name */
    public static l.a f34801d = null;

    /* renamed from: g  reason: collision with root package name */
    public static volatile DeviceId f34802g = null;

    /* renamed from: i  reason: collision with root package name */
    public static CuidChangeCallback f34803i = null;
    public static boolean sDataCuidInfoShable = true;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final Context f34804c;

    /* renamed from: e  reason: collision with root package name */
    public l f34805e;

    /* renamed from: f  reason: collision with root package name */
    public k f34806f;

    /* renamed from: h  reason: collision with root package name */
    public f f34807h;
    public Executor j;

    /* loaded from: classes6.dex */
    public interface CuidChangeCallback {
        void onCuidChanged(String str, String str2, CuidChangeReceivedCallback cuidChangeReceivedCallback);
    }

    /* loaded from: classes6.dex */
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
        this.j = new ThreadPoolExecutor(0, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f34804c = context.getApplicationContext();
        this.f34807h = new f();
        this.f34805e = new l(this.f34804c, new a(this.f34804c), this.f34807h);
        this.f34806f = new k(this.f34804c, this.f34807h);
    }

    private l.a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) ? this.f34805e.k(str) : (l.a) invokeL.objValue;
    }

    private l.a a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, this, str, str2)) == null) {
            l.a m = this.f34805e.m(str2);
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
                if (f34802g == null) {
                    f34802g = new DeviceId(context);
                }
                deviceId = f34802g;
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
            if (f34801d == null) {
                synchronized (j.class) {
                    if (f34801d == null) {
                        SystemClock.uptimeMillis();
                        f34801d = a(context).c();
                        SystemClock.uptimeMillis();
                    }
                }
            }
            a(context).d();
            return f34801d;
        }
        return (l.a) invokeL.objValue;
    }

    private l.a b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, this, str, str2)) == null) {
            j b2 = this.f34806f.b(str);
            if (b2 == null || TextUtils.equals(str2, b2.f3450a)) {
                return null;
            }
            return this.f34805e.b(b2);
        }
        return (l.a) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, aVar) == null) {
            this.j.execute(new Runnable(this, aVar) { // from class: com.baidu.android.common.util.DeviceId.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ l.a f34811a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ DeviceId f34812b;

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
                    this.f34812b = this;
                    this.f34811a = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (j.class) {
                            if (DeviceId.f34803i == null) {
                                return;
                            }
                            this.f34812b.f34805e.n();
                            this.f34811a.f(true);
                            this.f34812b.f34805e.j(this.f34811a, true, true);
                            CuidChangeCallback unused = DeviceId.f34803i = null;
                            this.f34812b.f34805e.p();
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
            this.f34805e.n();
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
                this.f34805e.p();
                throw th;
            }
        }
        return (l.a) invokeV.objValue;
    }

    private synchronized void c(l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, aVar) == null) {
            synchronized (this) {
                this.j.execute(d(aVar));
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
            public final /* synthetic */ l.a f34813a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ DeviceId f34814b;

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
                this.f34814b = this;
                this.f34813a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        this.f34814b.e(this.f34813a);
                    } finally {
                        this.f34814b.f34805e.p();
                    }
                }
            }
        } : (Runnable) invokeL.objValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            l.a aVar = f34801d;
            if (f34803i == null) {
                return;
            }
            if (aVar == null || aVar.t() || TextUtils.isEmpty(aVar.u())) {
                f34803i = null;
            } else {
                this.j.execute(new Runnable(this, aVar) { // from class: com.baidu.android.common.util.DeviceId.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ l.a f34808a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ DeviceId f34809b;

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
                        this.f34809b = this;
                        this.f34808a = aVar;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || DeviceId.f34803i == null) {
                            return;
                        }
                        l.a aVar2 = this.f34808a;
                        if (aVar2 == null || aVar2.t() || TextUtils.isEmpty(this.f34808a.u())) {
                            CuidChangeCallback unused = DeviceId.f34803i = null;
                        } else {
                            DeviceId.f34803i.onCuidChanged(this.f34808a.y(), this.f34808a.u(), new CuidChangeReceivedCallback(this) { // from class: com.baidu.android.common.util.DeviceId.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;

                                /* renamed from: a  reason: collision with root package name */
                                public final /* synthetic */ AnonymousClass1 f34810a;

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
                                    this.f34810a = this;
                                }

                                @Override // com.baidu.android.common.util.DeviceId.CuidChangeReceivedCallback
                                public void onCuidChangeReceived() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        AnonymousClass1 anonymousClass1 = this.f34810a;
                                        anonymousClass1.f34809b.b(anonymousClass1.f34808a);
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
            this.f34805e.j(aVar, true, false);
            this.f34806f.c(w);
            this.f34805e.i(aVar);
        }
    }

    private l.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) ? this.f34805e.a() : (l.a) invokeV.objValue;
    }

    private l.a g() {
        InterceptResult invokeV;
        j e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            File file = new File(this.f34804c.getFilesDir(), "libcuid.so");
            if (!file.exists() || (e2 = j.e(c.a(file))) == null) {
                return null;
            }
            return this.f34805e.b(e2);
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) ? a(context).f34807h.d(context.getApplicationContext()) : invokeL.booleanValue;
    }

    public static void registerCuidChangeEvent(Context context, CuidChangeCallback cuidChangeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65562, null, context, cuidChangeCallback) == null) {
            f34803i = cuidChangeCallback;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34805e : (l) invokeV.objValue;
    }
}
