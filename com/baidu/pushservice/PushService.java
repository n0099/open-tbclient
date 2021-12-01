package com.baidu.pushservice;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.f;
import com.baidu.android.pushservice.g;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class PushService extends Service {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f38532b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f38533c;

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f38534d;

    /* renamed from: e  reason: collision with root package name */
    public final Runnable f38535e;

    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PushService f38536e;

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
            this.f38536e = pushService;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g.b();
                this.f38536e.stopSelf();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ PushService f38537e;

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
            this.f38537e = pushService;
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
        this.f38532b = new Handler();
        this.f38533c = false;
        this.f38534d = new a(this);
        this.f38535e = new b(this);
    }

    private void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.a = z;
            com.baidu.android.pushservice.g.a.a("PushService", "stopSelf : exitOnDestroy=" + z + " --- immediate=" + z2, getApplicationContext());
            if (z2) {
                this.f38534d.run();
                return;
            }
            this.f38532b.removeCallbacks(this.f38534d);
            this.f38532b.postDelayed(this.f38534d, 1000L);
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
            com.baidu.android.pushservice.g.a.a("PushService", "onCreate from : " + getPackageName(), getApplicationContext());
            m.a("PushService onCreate from : " + getPackageName() + " at Time :" + System.currentTimeMillis(), getApplicationContext());
            boolean a2 = g.a(this).a();
            this.f38533c = a2;
            if (a2) {
                return;
            }
            a(true, false);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.onDestroy();
            com.baidu.android.pushservice.g.a.a("PushService", "onDestroy from : " + getPackageName(), getApplicationContext());
            m.a("PushService onDestroy from : " + getPackageName() + " at Time :" + System.currentTimeMillis(), getApplicationContext());
            g.b();
            if (this.a) {
                this.f38532b.removeCallbacks(this.f38535e);
                this.f38532b.postDelayed(this.f38535e, 1000L);
            }
            if (this.f38533c) {
                try {
                    sendBroadcast(f.a(this));
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
                com.baidu.android.pushservice.g.a.c("PushService", "--- onStart by null intent!", getApplicationContext());
            } else {
                try {
                    String uri = intent.toUri(0);
                    m.a("PushService onStartCommand from " + getPackageName() + " Intent " + uri + " at Time " + System.currentTimeMillis(), getApplicationContext());
                } catch (Exception e2) {
                    new b.c(getApplicationContext()).a(Log.getStackTraceString(e2)).a();
                }
            }
            this.f38532b.removeCallbacks(this.f38534d);
            this.f38532b.removeCallbacks(this.f38535e);
            try {
                boolean a2 = g.a(this).a(intent);
                this.f38533c = a2;
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
