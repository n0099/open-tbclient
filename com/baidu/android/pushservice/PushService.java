package com.baidu.android.pushservice;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.m;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class PushService extends Service {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f30246b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f30247c;

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f30248d;

    /* renamed from: e  reason: collision with root package name */
    public final Runnable f30249e;

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
        this.f30246b = new Handler();
        this.f30247c = false;
        this.f30248d = new Runnable(this) { // from class: com.baidu.android.pushservice.PushService.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PushService a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    f.a();
                    this.a.stopSelf();
                }
            }
        };
        this.f30249e = new Runnable(this) { // from class: com.baidu.android.pushservice.PushService.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ PushService a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i4 = newInitContext2.flag;
                    if ((i4 & 1) != 0) {
                        int i5 = i4 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    Process.killProcess(Process.myPid());
                }
            }
        };
    }

    private void a(boolean z, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)}) == null) {
            this.a = z;
            com.baidu.android.pushservice.f.a.a("PushService", "stopSelf : exitOnDestroy=" + z + " --- immediate=" + z2, getApplicationContext());
            if (z2) {
                this.f30248d.run();
                return;
            }
            this.f30246b.removeCallbacks(this.f30248d);
            this.f30246b.postDelayed(this.f30248d, 1000L);
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
                this.f30246b.removeCallbacks(this.f30249e);
                this.f30246b.postDelayed(this.f30249e, 1000L);
            }
            if (!this.f30247c || f.a(this).d()) {
                return;
            }
            try {
                sendBroadcast(e.a(this));
            } catch (Exception unused) {
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
                    String stringExtra = intent.getStringExtra("source");
                    if (!TextUtils.isEmpty(stringExtra) && !stringExtra.equals(getPackageName())) {
                        if (Build.VERSION.SDK_INT <= 23 && !m.i(this)) {
                            f.a(this).c();
                            a(true, true);
                            return 2;
                        }
                        new b.d(getApplicationContext()).d(501011L).a(System.currentTimeMillis()).c(stringExtra).a();
                    }
                } catch (Exception e2) {
                    new b.c(getApplicationContext()).a(Log.getStackTraceString(e2)).a();
                }
            }
            this.f30246b.removeCallbacks(this.f30248d);
            this.f30246b.removeCallbacks(this.f30249e);
            try {
                boolean a = f.a(this).a(intent);
                this.f30247c = a;
                if (a) {
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
