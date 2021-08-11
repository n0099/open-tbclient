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
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.m;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class PushService extends Service {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f36610a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f36611b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36612c;

    /* renamed from: d  reason: collision with root package name */
    public final Runnable f36613d;

    /* renamed from: e  reason: collision with root package name */
    public final Runnable f36614e;

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
        this.f36610a = false;
        this.f36611b = new Handler();
        this.f36612c = false;
        this.f36613d = new Runnable(this) { // from class: com.baidu.android.pushservice.PushService.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PushService f36615a;

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
                this.f36615a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    g.b();
                    this.f36615a.stopSelf();
                }
            }
        };
        this.f36614e = new Runnable(this) { // from class: com.baidu.android.pushservice.PushService.2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ PushService f36616a;

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
                this.f36616a = this;
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
            this.f36610a = z;
            com.baidu.android.pushservice.g.a.a("PushService", "stopSelf : exitOnDestroy=" + z + " --- immediate=" + z2, getApplicationContext());
            if (z2) {
                this.f36613d.run();
                return;
            }
            this.f36611b.removeCallbacks(this.f36613d);
            this.f36611b.postDelayed(this.f36613d, 1000L);
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
            this.f36612c = a2;
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
            if (this.f36610a) {
                this.f36611b.removeCallbacks(this.f36614e);
                this.f36611b.postDelayed(this.f36614e, 1000L);
            }
            if (!this.f36612c || g.a(this).e()) {
                return;
            }
            try {
                sendBroadcast(f.a(this));
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
                com.baidu.android.pushservice.g.a.c("PushService", "--- onStart by null intent!", getApplicationContext());
            } else {
                try {
                    String uri = intent.toUri(0);
                    m.a("PushService onStartCommand from " + getPackageName() + " Intent " + uri + " at Time " + System.currentTimeMillis(), getApplicationContext());
                    String stringExtra = intent.getStringExtra("source");
                    if (!TextUtils.isEmpty(stringExtra) && !stringExtra.equals(getPackageName())) {
                        if (Build.VERSION.SDK_INT <= 23 && !m.i(this)) {
                            g.a(this).d();
                            a(true, true);
                            return 2;
                        }
                        new b.d(getApplicationContext()).d(501011L).a(System.currentTimeMillis()).c(stringExtra).a();
                    }
                } catch (Exception e2) {
                    new b.c(getApplicationContext()).a(Log.getStackTraceString(e2)).a();
                }
            }
            this.f36611b.removeCallbacks(this.f36613d);
            this.f36611b.removeCallbacks(this.f36614e);
            try {
                boolean a2 = g.a(this).a(intent);
                this.f36612c = a2;
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
