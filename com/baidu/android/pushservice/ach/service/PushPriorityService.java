package com.baidu.android.pushservice.ach.service;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.ach.e.d;
import com.baidu.android.pushservice.ach.receiver.PushScreenReceiver;
import com.baidu.android.pushservice.ach.service.PushPriorityService;
import com.baidu.android.pushservice.e;
import com.baidu.android.pushservice.manageach.components.BaseAchService;
import com.baidu.android.pushservice.t.a;
import com.baidu.android.pushservice.v.c;
import com.baidu.protect.sdk.Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class PushPriorityService extends BaseAchService implements PushScreenReceiver.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Handler a;
    public Runnable b;

    /* loaded from: classes.dex */
    public static final class PushPriorityInnerService extends BaseAchService {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public PushPriorityInnerService() {
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

        @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
        public int a(Intent intent, int i, int i2) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, intent, i, i2)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.i(-16063, this, intent, Integer.valueOf(i), Integer.valueOf(i2)) : invokeLII.intValue;
        }

        @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
        public IBinder a(Intent intent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent)) == null) ? (IBinder) Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.l(-16058, this, intent) : (IBinder) invokeL.objValue;
        }

        @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-16057, this, null);
            }
        }

        @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.v(-16060, this, null);
            }
        }

        @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
        public boolean b(Intent intent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, intent)) == null) ? Aefe832488d495a9ec8e7e2dce0e2c1ce63d62cd6.z(-16059, this, intent) : invokeL.booleanValue;
        }
    }

    public PushPriorityService() {
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
        this.a = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        try {
            Intent j = e.j(getApplicationContext());
            j.putExtra("push_start_source", 4);
            getApplicationContext().sendBroadcast(j);
        } catch (Exception unused) {
        }
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
    public int a(Intent intent, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, intent, i, i2)) == null) {
            d.a(getApplicationContext()).a(this, intent, 10340, false);
            a(getApplicationContext());
            e();
            return 1;
        }
        return invokeLII.intValue;
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
    public IBinder a(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, intent)) == null) {
            return null;
        }
        return (IBinder) invokeL.objValue;
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            a.a(getApplicationContext()).a(4);
            c.a().a(getApplicationContext(), this);
            d();
        }
    }

    public final void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, context) == null) {
            try {
                startService(new Intent(context, PushPriorityInnerService.class));
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.baidu.android.pushservice.ach.receiver.PushScreenReceiver.a
    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048580, this, z) == null) && z) {
            d();
            stopSelf();
        }
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Runnable runnable = this.b;
            if (runnable != null) {
                this.a.removeCallbacks(runnable);
            }
            try {
                stopForeground(true);
            } catch (Exception unused) {
            }
            c.a().a(getApplicationContext(), (PushScreenReceiver.a) null);
        }
    }

    @Override // com.baidu.android.pushservice.manageach.components.BaseAchService
    public boolean b(Intent intent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, intent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void d() {
        Notification c;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || Build.VERSION.SDK_INT < 26 || (c = com.baidu.android.pushservice.ach.e.a.c(getApplicationContext())) == null) {
            return;
        }
        try {
            startForeground(10340, c);
            stopForeground(true);
        } catch (Exception unused) {
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            Runnable runnable = this.b;
            if (runnable == null) {
                this.b = new Runnable() { // from class: com.baidu.tieba.po
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // java.lang.Runnable
                    public final void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            PushPriorityService.this.c();
                        }
                    }
                };
            } else {
                this.a.removeCallbacks(runnable);
            }
            this.a.postDelayed(this.b, 30000L);
        }
    }
}
