package com.baidu.android.pushservice.job;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@TargetApi(21)
/* loaded from: classes.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static C0058a f3501a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f3502b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: com.baidu.android.pushservice.job.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0058a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Context f3503a;

        /* renamed from: b  reason: collision with root package name */
        public final JobScheduler f3504b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3505c;

        public C0058a(Context context) {
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
            this.f3503a = context;
            this.f3504b = (JobScheduler) context.getSystemService("jobscheduler");
        }

        private void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, this) == null) {
                this.f3505c = false;
                this.f3504b.cancel(1);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(65540, this, z) == null) {
                if (z || this.f3505c) {
                    long j = 300000;
                    if (z) {
                        a();
                        j = 300000 - (SystemClock.elapsedRealtime() % 300000);
                    }
                    this.f3505c = true;
                    JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.f3503a.getPackageName(), PushJobService.class.getName()));
                    builder.setMinimumLatency(j);
                    builder.setOverrideDeadline(j);
                    builder.setRequiredNetworkType(1);
                    builder.setPersisted(false);
                    this.f3504b.schedule(builder.build());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
                this.f3505c = false;
                this.f3504b.cancelAll();
            }
        }
    }

    public static synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, context) == null) {
            synchronized (a.class) {
                if (f3501a == null && Build.VERSION.SDK_INT >= 21) {
                    try {
                        f3501a = new C0058a(context);
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
                if (f3501a != null) {
                    try {
                        f3502b = true;
                        f3501a.a(z);
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
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? f3502b : invokeV.booleanValue;
    }

    public static synchronized void b(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, context) == null) {
            synchronized (a.class) {
                if (f3501a != null) {
                    try {
                        f3501a.b();
                    } catch (Exception e2) {
                        new b.c(context).a(Log.getStackTraceString(e2)).a();
                    }
                    f3501a = null;
                    f3502b = false;
                }
            }
        }
    }
}
