package com.baidu.android.common.util;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.e20;
import com.repackage.h20;
import com.repackage.q00;
import com.repackage.s00;
import com.repackage.t00;
import com.repackage.u00;
import java.io.File;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class DeviceId {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String f = "DeviceId";
    public static final boolean g = false;
    public static u00.a h = null;
    public static volatile DeviceId i = null;
    public static CuidChangeCallback j = null;
    public static boolean sDataCuidInfoShable = true;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public u00 b;
    public t00 c;
    public q00 d;
    public Executor e;

    /* loaded from: classes.dex */
    public interface CuidChangeCallback {
        void onCuidChanged(String str, String str2, CuidChangeReceivedCallback cuidChangeReceivedCallback);
    }

    /* loaded from: classes.dex */
    public interface CuidChangeReceivedCallback {
        void onCuidChangeReceived();
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u00.a a;
        public final /* synthetic */ DeviceId b;

        /* renamed from: com.baidu.android.common.util.DeviceId$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0007a implements CuidChangeReceivedCallback {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public C0007a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
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
                    aVar.b.d(aVar.a);
                }
            }
        }

        public a(DeviceId deviceId, u00.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {deviceId, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = deviceId;
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || DeviceId.j == null) {
                return;
            }
            u00.a aVar = this.a;
            if (aVar == null || aVar.w() || TextUtils.isEmpty(this.a.t())) {
                CuidChangeCallback unused = DeviceId.j = null;
            } else {
                DeviceId.j.onCuidChanged(this.a.r(), this.a.t(), new C0007a(this));
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u00.a a;
        public final /* synthetic */ DeviceId b;

        public b(DeviceId deviceId, u00.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {deviceId, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = deviceId;
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (s00.class) {
                    if (DeviceId.j == null) {
                        return;
                    }
                    this.b.b.i();
                    this.a.g(true);
                    this.b.b.j(this.a, true, true);
                    CuidChangeCallback unused = DeviceId.j = null;
                    this.b.b.p();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ u00.a a;
        public final /* synthetic */ DeviceId b;

        public c(DeviceId deviceId, u00.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {deviceId, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = deviceId;
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    this.b.c(this.a);
                } finally {
                    this.b.b.p();
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
        this.e = new ThreadPoolExecutor(0, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.a = context.getApplicationContext();
        this.d = new q00();
        this.b = new u00(this.a, new e20(this.a), this.d);
        this.c = new t00(this.a, this.d);
    }

    public static DeviceId a(Context context) {
        InterceptResult invokeL;
        DeviceId deviceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            synchronized (s00.class) {
                if (i == null) {
                    i = new DeviceId(context);
                }
                deviceId = i;
            }
            return deviceId;
        }
        return (DeviceId) invokeL.objValue;
    }

    private u00.a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, this, str)) == null) ? this.b.m(str) : (u00.a) invokeL.objValue;
    }

    private u00.a a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, this, str, str2)) == null) {
            s00 g2 = this.c.g(str);
            if (g2 == null || TextUtils.equals(str2, g2.a)) {
                return null;
            }
            return this.b.a(g2);
        }
        return (u00.a) invokeLL.objValue;
    }

    private Runnable a(u00.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65544, this, aVar)) == null) ? new c(this, aVar) : (Runnable) invokeL.objValue;
    }

    private u00.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, this)) == null) {
            this.b.i();
            try {
                u00.a e = e();
                if (!b(e)) {
                    if (e == null) {
                        e = b((String) null, (String) null);
                    }
                    if (e == null) {
                        e = a((String) null);
                    }
                    e(e);
                    return e;
                }
                u00.a b2 = b((String) null, e.n());
                if (b2 == null) {
                    b2 = a((String) null);
                }
                b2.g(false);
                b2.f(e.r());
                e(b2);
                return b2;
            } catch (Throwable th) {
                this.b.p();
                throw th;
            }
        }
        return (u00.a) invokeV.objValue;
    }

    public static u00.a b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, context)) == null) {
            if (h == null) {
                synchronized (s00.class) {
                    if (h == null) {
                        SystemClock.uptimeMillis();
                        h = a(context).b();
                        SystemClock.uptimeMillis();
                    }
                }
            }
            a(context).d();
            return h;
        }
        return (u00.a) invokeL.objValue;
    }

    private u00.a b(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, str, str2)) == null) {
            u00.a o = this.b.o(str2);
            return o == null ? a(str, str2) : o;
        }
        return (u00.a) invokeLL.objValue;
    }

    private boolean b(u00.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65550, this, aVar)) == null) ? (aVar == null || !aVar.m() || TextUtils.isEmpty(aVar.u()) || TextUtils.equals(aVar.u(), u00.n())) ? false : true : invokeL.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(u00.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, aVar) == null) {
            if (aVar == null) {
                throw new NullPointerException("cuidV270Info should not be null");
            }
            s00 y = aVar.y();
            if (!aVar.m() || TextUtils.isEmpty(aVar.u())) {
                aVar.e();
            }
            this.b.j(aVar, true, false);
            this.c.c(y);
            this.b.g(aVar);
        }
    }

    private void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            u00.a aVar = h;
            if (j == null) {
                return;
            }
            if (aVar == null || aVar.w() || TextUtils.isEmpty(aVar.t())) {
                j = null;
            } else {
                this.e.execute(new a(this, aVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(u00.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65553, this, aVar) == null) {
            this.e.execute(new b(this, aVar));
        }
    }

    private u00.a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            u00.a g2 = g();
            return g2 == null ? f() : g2;
        }
        return (u00.a) invokeV.objValue;
    }

    private synchronized void e(u00.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65555, this, aVar) == null) {
            synchronized (this) {
                this.e.execute(a(aVar));
            }
        }
    }

    private u00.a f() {
        InterceptResult invokeV;
        s00 a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65556, this)) == null) {
            File file = new File(this.a.getFilesDir(), "libcuid.so");
            if (!file.exists() || (a2 = s00.a(h20.a(file))) == null) {
                return null;
            }
            return this.b.a(a2);
        }
        return (u00.a) invokeV.objValue;
    }

    private u00.a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65557, this)) == null) ? this.b.k() : (u00.a) invokeV.objValue;
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65561, null, context)) == null) ? a(context).d.d(context.getApplicationContext()) : invokeL.booleanValue;
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

    public u00 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (u00) invokeV.objValue;
    }
}
