package com.baidu.android.pushservice.job;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@TargetApi(21)
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public static C0057a a;
    public static boolean b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.pushservice.job.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0057a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Context a;
        public final JobScheduler b;
        public boolean c;

        public C0057a(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = context;
            this.b = (JobScheduler) context.getSystemService("jobscheduler");
        }

        private void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                this.c = false;
                this.b.cancel(1);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
                if (z || this.c) {
                    long j = 300000;
                    if (z) {
                        a();
                        j = 300000 - (SystemClock.elapsedRealtime() % 300000);
                    }
                    this.c = true;
                    JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.a.getPackageName(), PushJobService.class.getName()));
                    builder.setMinimumLatency(j);
                    builder.setOverrideDeadline(j);
                    builder.setRequiredNetworkType(1);
                    builder.setPersisted(false);
                    PersistableBundle persistableBundle = new PersistableBundle();
                    persistableBundle.putInt("push_start_source", i);
                    builder.setExtras(persistableBundle);
                    this.b.schedule(builder.build());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65541, this) == null) {
                this.c = false;
                this.b.cancelAll();
            }
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, context) == null) {
            synchronized (a.class) {
                if (a == null && Build.VERSION.SDK_INT >= 21) {
                    try {
                        a = new C0057a(context);
                    } catch (Exception e) {
                        new b.c(context).a(Log.getStackTraceString(e)).a();
                    }
                }
            }
        }
    }

    public static synchronized void a(Context context, boolean z, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{context, Boolean.valueOf(z), Integer.valueOf(i)}) == null) {
            synchronized (a.class) {
                if (a != null) {
                    try {
                        b = true;
                        a.a(z, i);
                    } catch (Exception e) {
                        new b.c(context).a(Log.getStackTraceString(e)).a();
                    }
                }
            }
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b : invokeV.booleanValue;
    }

    public static synchronized void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            synchronized (a.class) {
                if (a != null) {
                    try {
                        a.b();
                    } catch (Exception e) {
                        new b.c(context).a(Log.getStackTraceString(e)).a();
                    }
                    a = null;
                    b = false;
                }
            }
        }
    }
}
