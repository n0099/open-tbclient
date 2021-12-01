package com.baidu.android.pushservice.job;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@TargetApi(21)
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static C1685a a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f32803b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.pushservice.job.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1685a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;

        /* renamed from: b  reason: collision with root package name */
        public final JobScheduler f32804b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f32805c;

        public C1685a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.f32804b = (JobScheduler) context.getSystemService("jobscheduler");
        }

        private void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                this.f32805c = false;
                this.f32804b.cancel(1);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TRACKBALL, this, z) == null) {
                if (z || this.f32805c) {
                    long j2 = 300000;
                    if (z) {
                        a();
                        j2 = 300000 - (SystemClock.elapsedRealtime() % 300000);
                    }
                    this.f32805c = true;
                    JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.a.getPackageName(), PushJobService.class.getName()));
                    builder.setMinimumLatency(j2);
                    builder.setOverrideDeadline(j2);
                    builder.setRequiredNetworkType(1);
                    builder.setPersisted(false);
                    this.f32804b.schedule(builder.build());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65541, this) == null) {
                this.f32805c = false;
                this.f32804b.cancelAll();
            }
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, context) == null) {
            synchronized (a.class) {
                if (a == null && Build.VERSION.SDK_INT >= 21) {
                    try {
                        a = new C1685a(context);
                    } catch (Exception e2) {
                        new b.c(context).a(Log.getStackTraceString(e2)).a();
                    }
                }
            }
        }
    }

    public static synchronized void a(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65537, null, context, z) == null) {
            synchronized (a.class) {
                if (a != null) {
                    try {
                        f32803b = true;
                        a.a(z);
                    } catch (Exception e2) {
                        new b.c(context).a(Log.getStackTraceString(e2)).a();
                    }
                }
            }
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f32803b : invokeV.booleanValue;
    }

    public static synchronized void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            synchronized (a.class) {
                if (a != null) {
                    try {
                        a.b();
                    } catch (Exception e2) {
                        new b.c(context).a(Log.getStackTraceString(e2)).a();
                    }
                    a = null;
                    f32803b = false;
                }
            }
        }
    }
}
