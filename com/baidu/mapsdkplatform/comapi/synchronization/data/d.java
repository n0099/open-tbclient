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
/* loaded from: classes2.dex */
public class d {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String a = "d";
    public static int b = 0;
    public static g c = null;
    public static Thread d = null;
    public static volatile boolean e = true;
    public static volatile long g = 5000;
    public static long h = 5000;
    public static volatile boolean i = false;
    public static int j = 1000;
    public transient /* synthetic */ FieldHolder $fh;
    public c f;
    public boolean k;

    /* loaded from: classes2.dex */
    public class a {
        public static /* synthetic */ Interceptable $ic;
        public static final d a;
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
            a = new d(null);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String a;

        public b(String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                while (!d.e) {
                    if (d.c != null) {
                        d.c.a(d.b, d.i);
                        boolean unused = d.i = false;
                    }
                    try {
                        Thread.sleep(d.g);
                    } catch (InterruptedException unused2) {
                        Thread.currentThread().interrupt();
                    }
                    int d = d.c != null ? d.c.d() : 0;
                    if (d >= 3) {
                        long j = (d / 3) + 1;
                        long unused3 = d.g = d.h * j < 60000 ? d.h * j : 60000L;
                    } else {
                        long unused4 = d.g = d.h;
                    }
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        private void a(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(65537, this, i) == null) {
                if (d.j == i) {
                    boolean unused = d.i = false;
                    return;
                }
                boolean unused2 = d.i = true;
                int unused3 = d.j = i;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                String str = d.a;
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.a(str, "The order state is: " + message.what);
                a(message.what);
                int i = message.what;
                if (i != 0) {
                    if (i == 1 || i == 2 || i == 3 || i == 4) {
                        d.q();
                        return;
                    } else if (i != 5) {
                        com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(d.a, "The order state is undefined");
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
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? a.a : (d) invokeV.objValue;
    }

    private void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            e = true;
            Thread thread = d;
            if (thread != null) {
                thread.interrupt();
                d = null;
            }
        }
    }

    public static synchronized void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, null) == null) {
            synchronized (d.class) {
                e = true;
            }
        }
    }

    public static synchronized void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, null) == null) {
            synchronized (d.class) {
                if (d == null) {
                    return;
                }
                e = false;
                if (Thread.State.NEW == d.getState()) {
                    d.start();
                }
                if (Thread.State.TERMINATED == d.getState()) {
                    d = null;
                    Thread thread = new Thread(new b(Thread.currentThread().getName()));
                    d = thread;
                    thread.start();
                }
            }
        }
    }

    public synchronized void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            synchronized (this) {
                String str = a;
                com.baidu.mapsdkplatform.comapi.synchronization.d.a.c(str, "The order state = " + i2);
                b = i2;
                if (this.f == null) {
                    com.baidu.mapsdkplatform.comapi.synchronization.d.a.b(a, "SyncDataRequestHandler is null");
                    return;
                }
                Message obtainMessage = this.f.obtainMessage();
                obtainMessage.what = i2;
                this.f.sendMessage(obtainMessage);
            }
        }
    }

    public void a(View view2) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2) == null) || (gVar = c) == null) {
            return;
        }
        gVar.a(view2);
    }

    public void a(DisplayOptions displayOptions) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, displayOptions) == null) || (gVar = c) == null) {
            return;
        }
        gVar.a(displayOptions);
    }

    public void a(RoleOptions roleOptions) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, roleOptions) == null) || (gVar = c) == null) {
            return;
        }
        gVar.a(roleOptions);
    }

    public void a(RoleOptions roleOptions, DisplayOptions displayOptions) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, roleOptions, displayOptions) == null) {
            g a2 = g.a();
            c = a2;
            if (a2 != null) {
                a2.b();
                c.a(roleOptions);
                c.a(displayOptions);
            }
            d = new Thread(new b(Thread.currentThread().getName()));
            this.f = new c();
        }
    }

    public void a(k kVar) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, kVar) == null) || (gVar = c) == null) {
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
            h = j2;
            g = j2;
        }
    }

    public void b(View view2) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) || (gVar = c) == null) {
            return;
        }
        gVar.b(view2);
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            p();
        }
    }

    public void c(View view2) {
        g gVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048586, this, view2) == null) || (gVar = c) == null) {
            return;
        }
        gVar.c(view2);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            o();
            this.f.removeCallbacksAndMessages(null);
            b = 0;
            h = 5000L;
            i = false;
            j = 1000;
            this.k = true;
            g gVar = c;
            if (gVar != null) {
                gVar.h();
            }
        }
    }
}
