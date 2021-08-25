package com.baidu.android.common.util;

import android.content.Context;
import android.os.SystemClock;
import androidx.core.view.InputDeviceCompat;
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
/* loaded from: classes4.dex */
public final class DeviceId {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f36581a = "DeviceId";

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f36582b = false;

    /* renamed from: d  reason: collision with root package name */
    public static l.a f36583d = null;

    /* renamed from: g  reason: collision with root package name */
    public static volatile DeviceId f36584g = null;
    public static boolean sDataCuidInfoShable = true;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final Context f36585c;

    /* renamed from: e  reason: collision with root package name */
    public l f36586e;

    /* renamed from: f  reason: collision with root package name */
    public k f36587f;

    /* renamed from: h  reason: collision with root package name */
    public f f36588h;

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
        this.f36585c = context.getApplicationContext();
        this.f36588h = new f();
        this.f36586e = new l(this.f36585c, new a(this.f36585c), this.f36588h);
        this.f36587f = new k(this.f36585c, this.f36588h);
    }

    private l.a a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, str)) == null) {
            l.a o = this.f36586e.o();
            return o == null ? b(str) : o;
        }
        return (l.a) invokeL.objValue;
    }

    public static DeviceId a(Context context) {
        InterceptResult invokeL;
        DeviceId deviceId;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            synchronized (j.class) {
                if (f36584g == null) {
                    f36584g = new DeviceId(context);
                }
                deviceId = f36584g;
            }
            return deviceId;
        }
        return (DeviceId) invokeL.objValue;
    }

    private synchronized void a(l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, aVar) == null) {
            synchronized (this) {
                new Thread(b(aVar)).start();
            }
        }
    }

    private l.a b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            this.f36586e.l();
            try {
                l.a c2 = c();
                if (c2 == null) {
                    c2 = a((String) null);
                }
                if (c2 == null) {
                    c2 = c((String) null);
                }
                a(c2);
                return c2;
            } catch (Throwable th) {
                this.f36586e.n();
                throw th;
            }
        }
        return (l.a) invokeV.objValue;
    }

    public static l.a b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, context)) == null) {
            if (f36583d == null) {
                synchronized (j.class) {
                    if (f36583d == null) {
                        SystemClock.uptimeMillis();
                        f36583d = a(context).b();
                        SystemClock.uptimeMillis();
                    }
                }
            }
            return f36583d;
        }
        return (l.a) invokeL.objValue;
    }

    private l.a b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, this, str)) == null) {
            j b2 = this.f36587f.b(str);
            if (b2 != null) {
                return this.f36586e.b(b2);
            }
            return null;
        }
        return (l.a) invokeL.objValue;
    }

    private Runnable b(l.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65546, this, aVar)) == null) ? new Runnable(this, aVar) { // from class: com.baidu.android.common.util.DeviceId.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ l.a f36589a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ DeviceId f36590b;

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
                this.f36590b = this;
                this.f36589a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    try {
                        this.f36590b.c(this.f36589a);
                    } finally {
                        this.f36590b.f36586e.n();
                    }
                }
            }
        } : (Runnable) invokeL.objValue;
    }

    private l.a c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65547, this)) == null) {
            l.a d2 = d();
            return d2 == null ? e() : d2;
        }
        return (l.a) invokeV.objValue;
    }

    private l.a c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65548, this, str)) == null) ? this.f36586e.k(str) : (l.a) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(l.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, aVar) == null) {
            if (aVar == null) {
                throw new NullPointerException("cuidV270Info should not be null");
            }
            j l = aVar.l();
            this.f36586e.j(aVar, true, false);
            this.f36587f.c(l);
            this.f36586e.i(aVar);
        }
    }

    private l.a d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) ? this.f36586e.a() : (l.a) invokeV.objValue;
    }

    private l.a e() {
        InterceptResult invokeV;
        j e2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) {
            File file = new File(this.f36585c.getFilesDir(), "libcuid.so");
            if (!file.exists() || (e2 = j.e(c.a(file))) == null) {
                return null;
            }
            return this.f36586e.b(e2);
        }
        return (l.a) invokeV.objValue;
    }

    public static String getCUID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65552, null, context)) == null) ? b(context).n() : (String) invokeL.objValue;
    }

    public static String getDeviceID(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65553, null, context)) == null) ? b(context).e() : (String) invokeL.objValue;
    }

    public static boolean isMySelfTrusted(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65554, null, context)) == null) ? a(context).f36588h.d(context.getApplicationContext()) : invokeL.booleanValue;
    }

    @Deprecated
    public static void setCuidDataShable(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65555, null, context, z) == null) {
        }
    }

    public l a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f36586e : (l) invokeV.objValue;
    }
}
