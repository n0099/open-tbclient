package com.baidu.android.common.util;

import android.app.Application;
import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.g00;
import com.baidu.tieba.k00;
import com.baidu.tieba.o00;
import com.baidu.tieba.p00;
import com.baidu.tieba.q00;
import com.baidu.tieba.r00;
import com.baidu.tieba.s00;
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
/* loaded from: classes.dex */
public final class DeviceId {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "DeviceId";
    public static final boolean b = false;
    public static s00.a d = null;
    public static volatile DeviceId g = null;
    public static CuidChangeCallback i = null;
    public static boolean sDataCuidInfoShable = true;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context c;
    public s00 e;
    public q00 f;
    public g00 h;
    public Executor j;

    /* loaded from: classes.dex */
    public interface CuidChangeCallback {
        void onCuidChanged(String str, String str2, CuidChangeReceivedCallback cuidChangeReceivedCallback);
    }

    /* loaded from: classes.dex */
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
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null && (context instanceof Application)) {
            this.c = context;
        } else {
            this.c = applicationContext;
        }
        this.h = new g00();
        this.e = new s00(this.c, new k00(this.c), this.h);
        this.f = new q00(this.c, this.h);
    }

    public static DeviceId a(Context context) {
        InterceptResult invokeL;
        DeviceId deviceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            synchronized (p00.class) {
                if (g == null) {
                    g = new DeviceId(context);
                }
                deviceId = g;
            }
            return deviceId;
        }
        return (DeviceId) invokeL.objValue;
    }

    private s00.a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, str)) == null) ? this.e.k(str) : (s00.a) invokeL.objValue;
    }

    private s00.a a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, this, str, str2)) == null) {
            s00.a m = this.e.m(str2);
            return m == null ? b(str, str2) : m;
        }
        return (s00.a) invokeLL.objValue;
    }

    private boolean a(s00.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, this, aVar)) == null) ? (aVar == null || !aVar.r() || TextUtils.isEmpty(aVar.s()) || TextUtils.equals(aVar.s(), s00.l())) ? false : true : invokeL.booleanValue;
    }

    public static s00.a b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, context)) == null) {
            if (d == null) {
                synchronized (p00.class) {
                    if (d == null) {
                        SystemClock.uptimeMillis();
                        d = a(context).c();
                        SystemClock.uptimeMillis();
                    }
                }
            }
            a(context).d();
            return d;
        }
        return (s00.a) invokeL.objValue;
    }

    private s00.a b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, this, str, str2)) == null) {
            p00 b2 = this.f.b(str);
            if (b2 == null || TextUtils.equals(str2, b2.a) || !r00.a(b2.a)) {
                return null;
            }
            return this.e.b(b2);
        }
        return (s00.a) invokeLL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(s00.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, aVar) == null) {
            this.j.execute(new Runnable(this, aVar) { // from class: com.baidu.android.common.util.DeviceId.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ s00.a a;
                public final /* synthetic */ DeviceId b;

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
                    this.b = this;
                    this.a = aVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        synchronized (p00.class) {
                            if (DeviceId.i == null) {
                                return;
                            }
                            this.b.e.n();
                            this.a.f(true);
                            this.b.e.j(this.a, true, true);
                            CuidChangeCallback unused = DeviceId.i = null;
                            this.b.e.p();
                        }
                    }
                }
            });
        }
    }

    private s00.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            this.e.n();
            try {
                s00.a e = e();
                boolean a2 = a(e);
                boolean z = (e == null || r00.a(e.h())) ? false : true;
                if (!a2 && !z) {
                    if (e == null) {
                        e = a((String) null, (String) null);
                    }
                    if (e == null) {
                        e = a((String) null);
                    }
                    c(e);
                    return e;
                }
                s00.a a3 = a((String) null, e.h());
                if (a3 == null) {
                    a3 = a((String) null);
                }
                a3.f(false);
                a3.e(e.A());
                c(a3);
                return a3;
            } catch (Throwable th) {
                this.e.p();
                throw th;
            }
        }
        return (s00.a) invokeV.objValue;
    }

    private synchronized void c(s00.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, aVar) == null) {
            synchronized (this) {
                this.j.execute(d(aVar));
            }
        }
    }

    private Runnable d(s00.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, this, aVar)) == null) ? new Runnable(this, aVar) { // from class: com.baidu.android.common.util.DeviceId.3
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ s00.a a;
            public final /* synthetic */ DeviceId b;

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
                this.b = this;
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        this.b.e(this.a);
                    } finally {
                        this.b.e.p();
                    }
                }
            }
        } : (Runnable) invokeL.objValue;
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            s00.a aVar = d;
            if (i == null) {
                return;
            }
            if (aVar == null || aVar.u() || TextUtils.isEmpty(aVar.v())) {
                i = null;
            } else {
                this.j.execute(new Runnable(this, aVar) { // from class: com.baidu.android.common.util.DeviceId.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ s00.a a;
                    public final /* synthetic */ DeviceId b;

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
                        this.b = this;
                        this.a = aVar;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || DeviceId.i == null) {
                            return;
                        }
                        s00.a aVar2 = this.a;
                        if (aVar2 == null || aVar2.u() || TextUtils.isEmpty(this.a.v())) {
                            CuidChangeCallback unused = DeviceId.i = null;
                        } else {
                            DeviceId.i.onCuidChanged(this.a.A(), this.a.v(), new CuidChangeReceivedCallback(this) { // from class: com.baidu.android.common.util.DeviceId.1.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass1 a;

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
                                    this.a = this;
                                }

                                @Override // com.baidu.android.common.util.DeviceId.CuidChangeReceivedCallback
                                public void onCuidChangeReceived() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        AnonymousClass1 anonymousClass1 = this.a;
                                        anonymousClass1.b.b(anonymousClass1.a);
                                    }
                                }
                            });
                        }
                    }
                });
            }
        }
    }

    private s00.a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            s00.a f = f();
            return f == null ? g() : f;
        }
        return (s00.a) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(s00.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, aVar) == null) {
            if (aVar == null) {
                throw new NullPointerException("cuidV270Info should not be null");
            }
            p00 y = aVar.y();
            if (!aVar.r() || TextUtils.isEmpty(aVar.s())) {
                aVar.w();
            }
            this.e.j(aVar, true, false);
            if (aVar.x()) {
                return;
            }
            this.f.c(y);
            this.e.i(aVar);
        }
    }

    private s00.a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) ? this.e.a() : (s00.a) invokeV.objValue;
    }

    private s00.a g() {
        InterceptResult invokeV;
        p00 e;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) {
            File file = new File(this.c.getFilesDir(), "libcuid.so");
            if (!file.exists() || (e = p00.e(o00.a(file))) == null) {
                return null;
            }
            return this.e.b(e);
        }
        return (s00.a) invokeV.objValue;
    }

    public static String getCUID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65558, null, context)) == null) ? b(context).A() : (String) invokeL.objValue;
    }

    public static String getDeviceID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65559, null, context)) == null) ? b(context).h() : (String) invokeL.objValue;
    }

    public static String getOldCUID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65560, null, context)) == null) ? b(context).v() : (String) invokeL.objValue;
    }

    public static boolean isMySelfTrusted(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) ? a(context).h.d(context.getApplicationContext()) : invokeL.booleanValue;
    }

    public static void registerCuidChangeEvent(Context context, CuidChangeCallback cuidChangeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65562, null, context, cuidChangeCallback) == null) {
            i = cuidChangeCallback;
            b(context);
        }
    }

    @Deprecated
    public static void setCuidDataShable(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65563, null, context, z) == null) {
        }
    }

    public s00 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.e : (s00) invokeV.objValue;
    }
}
