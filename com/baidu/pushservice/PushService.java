package com.baidu.pushservice;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.e;
import com.baidu.android.pushservice.f;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class PushService extends Service {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;
    public Handler b;
    public boolean c;
    public final Runnable d;
    public final Runnable e;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PushService a;

        public a(PushService pushService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pushService;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f.a();
                this.a.stopSelf();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PushService a;

        public b(PushService pushService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pushService;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Process.killProcess(Process.myPid());
            }
        }
    }

    public PushService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = new Handler();
        this.c = false;
        this.d = new a(this);
        this.e = new b(this);
    }

    private void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.a = z;
            com.baidu.android.pushservice.f.a.a("PushService", "stopSelf : exitOnDestroy=" + z + " --- immediate=" + z2, getApplicationContext());
            if (z2) {
                this.d.run();
                return;
            }
            this.b.removeCallbacks(this.d);
            this.b.postDelayed(this.d, 1000L);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onCreate();
            com.baidu.android.pushservice.f.a.a("PushService", "onCreate from : " + getPackageName(), getApplicationContext());
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            com.baidu.android.pushservice.f.a.a("PushService", "onDestroy from : " + getPackageName(), getApplicationContext());
            f.a();
            if (this.a) {
                this.b.removeCallbacks(this.e);
                this.b.postDelayed(this.e, 1000L);
            }
            if (this.c) {
                try {
                    sendBroadcast(e.a(this));
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, intent, i, i2)) == null) {
            if (intent == null) {
                intent = new Intent();
                com.baidu.android.pushservice.f.a.c("PushService", "--- onStart by null intent!", getApplicationContext());
            } else {
                try {
                    intent.toUri(0);
                } catch (Exception e) {
                    new b.c(getApplicationContext()).a(Log.getStackTraceString(e)).a();
                }
            }
            this.b.removeCallbacks(this.d);
            this.b.removeCallbacks(this.e);
            try {
                boolean a2 = f.a(this).a(intent);
                this.c = a2;
                if (a2) {
                    return 1;
                }
                a(true, true);
                return 2;
            } catch (Exception e2) {
                a(true, true);
                new b.c(getApplicationContext()).a(Log.getStackTraceString(e2)).a();
                return 2;
            }
        }
        return invokeLII.intValue;
    }
}
