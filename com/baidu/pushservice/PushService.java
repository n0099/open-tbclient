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
/* loaded from: classes10.dex */
public class PushService extends Service {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f37882b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f37883c;

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f37884d;

    /* renamed from: e  reason: collision with root package name */
    public final Runnable f37885e;

    /* loaded from: classes10.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PushService f37886e;

        public a(PushService pushService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37886e = pushService;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                f.a();
                this.f37886e.stopSelf();
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PushService f37887e;

        public b(PushService pushService) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pushService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37887e = pushService;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = false;
        this.f37882b = new Handler();
        this.f37883c = false;
        this.f37884d = new a(this);
        this.f37885e = new b(this);
    }

    private void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.a = z;
            com.baidu.android.pushservice.f.a.a("PushService", "stopSelf : exitOnDestroy=" + z + " --- immediate=" + z2, getApplicationContext());
            if (z2) {
                this.f37884d.run();
                return;
            }
            this.f37882b.removeCallbacks(this.f37884d);
            this.f37882b.postDelayed(this.f37884d, 1000L);
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
                this.f37882b.removeCallbacks(this.f37885e);
                this.f37882b.postDelayed(this.f37885e, 1000L);
            }
            if (this.f37883c) {
                try {
                    sendBroadcast(e.a(this));
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048579, this, intent, i2, i3)) == null) {
            if (intent == null) {
                intent = new Intent();
                com.baidu.android.pushservice.f.a.c("PushService", "--- onStart by null intent!", getApplicationContext());
            } else {
                try {
                    intent.toUri(0);
                } catch (Exception e2) {
                    new b.c(getApplicationContext()).a(Log.getStackTraceString(e2)).a();
                }
            }
            this.f37882b.removeCallbacks(this.f37884d);
            this.f37882b.removeCallbacks(this.f37885e);
            try {
                boolean a2 = f.a(this).a(intent);
                this.f37883c = a2;
                if (a2) {
                    return 1;
                }
                a(true, true);
                return 2;
            } catch (Exception e3) {
                a(true, true);
                new b.c(getApplicationContext()).a(Log.getStackTraceString(e3)).a();
                return 2;
            }
        }
        return invokeLII.intValue;
    }
}
