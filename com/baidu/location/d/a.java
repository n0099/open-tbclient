package com.baidu.location.d;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.location.LLSInterface;
import com.baidu.location.b.h;
import com.baidu.location.b.l;
import com.baidu.location.b.o;
import com.baidu.location.b.u;
import com.baidu.location.b.v;
import com.baidu.location.b.w;
import com.baidu.location.b.x;
import com.baidu.location.c.e;
import com.baidu.location.c.i;
import com.baidu.location.e.k;
import com.baidu.location.f;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class a extends Service implements LLSInterface {
    public static /* synthetic */ Interceptable $ic;
    public static HandlerC0101a a;
    public static long c;
    public static long g;
    public transient /* synthetic */ FieldHolder $fh;
    public Messenger b;
    public Looper d;
    public HandlerThread e;
    public boolean f;
    public int h;

    /* renamed from: com.baidu.location.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class HandlerC0101a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final WeakReference<a> a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerC0101a(Looper looper, a aVar) {
            super(looper);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {looper, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || (aVar = this.a.get()) == null) {
                return;
            }
            if (f.isServing) {
                int i = message.what;
                if (i == 11) {
                    aVar.a(message);
                } else if (i == 12) {
                    aVar.b(message);
                } else if (i == 15) {
                    aVar.c(message);
                } else if (i == 22) {
                    l.c().b(message);
                } else if (i == 41) {
                    l.c().h();
                } else if (i == 401) {
                    try {
                        message.getData();
                    } catch (Exception unused) {
                    }
                } else if (i == 406) {
                    h.a().e();
                } else if (i == 705) {
                    com.baidu.location.b.a.a().a(message.getData().getBoolean(Constant.FOREGROUND));
                }
            }
            if (message.what == 1) {
                aVar.b();
            }
            if (message.what == 0) {
                aVar.a();
            }
            super.handleMessage(message);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1037782865, "Lcom/baidu/location/d/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1037782865, "Lcom/baidu/location/d/a;");
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = null;
        this.d = null;
        this.e = null;
        this.f = false;
        this.h = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            com.baidu.location.a.a.a().a(f.getServiceContext());
            com.baidu.location.e.b.a();
            try {
                x.a().e();
            } catch (Exception unused) {
            }
            h.a().b();
            e.a().b();
            com.baidu.location.c.b.a().b();
            l.c().d();
            i.a().c();
            this.h = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, message) == null) {
            Log.d("baidu_location_service", "baidu location service register ...");
            com.baidu.location.b.a.a().a(message);
            if (k.b()) {
                return;
            }
            o.b().c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            e.a().e();
            i.a().d();
            x.a().f();
            com.baidu.location.c.b.a().c();
            l.c().e();
            h.a().c();
            w.d();
            com.baidu.location.b.a.a().b();
            v.a().d();
            this.h = 4;
            Log.d("baidu_location_service", "baidu location service has stoped ...");
            if (this.f) {
                return;
            }
            Process.killProcess(Process.myPid());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, message) == null) {
            com.baidu.location.b.a.a().b(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, message) == null) {
            com.baidu.location.b.a.a().c(message);
        }
    }

    @Override // com.baidu.location.LLSInterface
    public double getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return 7.929999828338623d;
        }
        return invokeV.doubleValue;
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent)) == null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                com.baidu.location.e.b.h = extras.getString("key");
                com.baidu.location.e.b.g = extras.getString("sign");
                this.f = extras.getBoolean("kill_process");
                extras.getBoolean("cache_exception");
            }
            return this.b.getBinder();
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // com.baidu.location.LLSInterface
    public void onCreate(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            try {
                k.ax = context.getPackageName();
            } catch (Exception unused) {
            }
            g = System.currentTimeMillis();
            HandlerThread a2 = u.a();
            this.e = a2;
            if (a2 != null) {
                this.d = a2.getLooper();
            }
            a = this.d == null ? new HandlerC0101a(Looper.getMainLooper(), this) : new HandlerC0101a(this.d, this);
            c = System.currentTimeMillis();
            this.b = new Messenger(a);
            a.sendEmptyMessage(0);
            this.h = 1;
            Log.d("baidu_location_service", "baidu location service start1 ...20190725..." + Process.myPid());
        }
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            try {
                a.sendEmptyMessage(1);
            } catch (Exception unused) {
                Log.d("baidu_location_service", "baidu location service stop exception...");
                b();
                Process.killProcess(Process.myPid());
            }
            this.h = 3;
            new Handler(Looper.getMainLooper()).postDelayed(new b(this, new WeakReference(this)), 1000L);
            Log.d("baidu_location_service", "baidu location service stop ...");
        }
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public int onStartCommand(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048580, this, intent, i, i2)) == null) {
            return 1;
        }
        return invokeLII.intValue;
    }

    @Override // android.app.Service, com.baidu.location.LLSInterface
    public void onTaskRemoved(Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, intent) == null) {
            Log.d("baidu_location_service", "baidu location service remove task...");
        }
    }

    @Override // com.baidu.location.LLSInterface
    public boolean onUnBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, intent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }
}
