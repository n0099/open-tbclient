package com.baidu.mapsdkplatform.comapi.synchronization.data;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mapapi.synchronization.DisplayOptions;
import com.baidu.mapapi.synchronization.RoleOptions;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.Thread;
/* loaded from: classes5.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: a  reason: collision with root package name */
    public static final String f42183a = "d";

    /* renamed from: b  reason: collision with root package name */
    public static int f42184b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static g f42185c = null;

    /* renamed from: d  reason: collision with root package name */
    public static Thread f42186d = null;

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f42187e = true;

    /* renamed from: g  reason: collision with root package name */
    public static volatile long f42188g = 5000;

    /* renamed from: h  reason: collision with root package name */
    public static long f42189h = 5000;

    /* renamed from: i  reason: collision with root package name */
    public static volatile boolean f42190i = false;

    /* renamed from: j  reason: collision with root package name */
    public static int f42191j = 1000;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public c f42192f;
    public boolean k;

    /* loaded from: classes5.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final d f42193a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(544666282, "Lcom/baidu/mapsdkplatform/comapi/synchronization/data/d$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(544666282, "Lcom/baidu/mapsdkplatform/comapi/synchronization/data/d$a;");
                    return;
                }
            }
            f42193a = new d(null);
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f42194a;

        public b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42194a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!d.f42187e) {
                    if (d.f42185c != null) {
                        d.f42185c.a(d.f42184b, d.f42190i);
                        boolean unused = d.f42190i = false;
                    }
                    try {
                        Thread.sleep(d.f42188g);
                    } catch (InterruptedException unused2) {
                        Thread.currentThread().interrupt();
                    }
                    int d2 = d.f42185c != null ? d.f42185c.d() : 0;
                    if (d2 >= 3) {
                        long j2 = (d2 / 3) + 1;
                        long unused3 = d.f42188g = d.f42189h * j2 < 60000 ? d.f42189h * j2 : 60000L;
                    } else {
                        long unused4 = d.f42188g = d.f42189h;
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        private void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65537, this, i2) == null) {
                if (d.f42191j == i2) {
                    boolean unused = d.f42190i = false;
                    return;
                }
                boolean unused2 = d.f42190i = true;
                int unused3 = d.f42191j = i2;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                String str = d.f42183a;
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(str, "The order state is: " + message.what);
                a(message.what);
                int i2 = message.what;
                if (i2 != 0) {
                    if (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) {
                        d.q();
                        return;
                    } else if (i2 != 5) {
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(d.f42183a, "The order state is undefined");
                        return;
                    }
                }
                d.p();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-178203961, "Lcom/baidu/mapsdkplatform/comapi/synchronization/data/d;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-178203961, "Lcom/baidu/mapsdkplatform/comapi/synchronization/data/d;");
        }
    }

    public d() {
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
        this.k = true;
    }

    public /* synthetic */ d(e eVar) {
        this();
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? a.f42193a : (d) invokeV.objValue;
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            f42187e = true;
            Thread thread = f42186d;
            if (thread != null) {
                thread.interrupt();
                f42186d = null;
            }
        }
    }

    public static synchronized void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            synchronized (d.class) {
                f42187e = true;
            }
        }
    }

    public static synchronized void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, null) == null) {
            synchronized (d.class) {
                if (f42186d == null) {
                    return;
                }
                f42187e = false;
                if (Thread.State.NEW == f42186d.getState()) {
                    f42186d.start();
                }
                if (Thread.State.TERMINATED == f42186d.getState()) {
                    f42186d = null;
                    Thread thread = new Thread(new b(Thread.currentThread().getName()));
                    f42186d = thread;
                    thread.start();
                }
            }
        }
    }

    public synchronized void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            synchronized (this) {
                String str = f42183a;
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, "The order state = " + i2);
                f42184b = i2;
                if (this.f42192f == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(f42183a, "SyncDataRequestHandler is null");
                    return;
                }
                Message obtainMessage = this.f42192f.obtainMessage();
                obtainMessage.what = i2;
                this.f42192f.sendMessage(obtainMessage);
            }
        }
    }

    public void a(View view) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view) == null) || (gVar = f42185c) == null) {
            return;
        }
        gVar.a(view);
    }

    public void a(DisplayOptions displayOptions) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, displayOptions) == null) || (gVar = f42185c) == null) {
            return;
        }
        gVar.a(displayOptions);
    }

    public void a(RoleOptions roleOptions) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, roleOptions) == null) || (gVar = f42185c) == null) {
            return;
        }
        gVar.a(roleOptions);
    }

    public void a(RoleOptions roleOptions, DisplayOptions displayOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, roleOptions, displayOptions) == null) {
            g a2 = g.a();
            f42185c = a2;
            if (a2 != null) {
                a2.b();
                f42185c.a(roleOptions);
                f42185c.a(displayOptions);
            }
            f42186d = new Thread(new b(Thread.currentThread().getName()));
            this.f42192f = new c();
        }
    }

    public void a(k kVar) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, kVar) == null) || (gVar = f42185c) == null) {
            return;
        }
        gVar.a(kVar);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            if (this.k) {
                this.k = false;
            } else {
                q();
            }
        }
    }

    public void b(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            long j2 = i2 * 1000;
            f42189h = j2;
            f42188g = j2;
        }
    }

    public void b(View view) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view) == null) || (gVar = f42185c) == null) {
            return;
        }
        gVar.b(view);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            p();
        }
    }

    public void c(View view) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, view) == null) || (gVar = f42185c) == null) {
            return;
        }
        gVar.c(view);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            o();
            this.f42192f.removeCallbacksAndMessages(null);
            f42184b = 0;
            f42189h = 5000L;
            f42190i = false;
            f42191j = 1000;
            this.k = true;
            g gVar = f42185c;
            if (gVar != null) {
                gVar.h();
            }
        }
    }
}
