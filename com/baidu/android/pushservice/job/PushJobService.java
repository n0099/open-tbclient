package com.baidu.android.pushservice.job;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.pushservice.f;
import com.baidu.android.pushservice.g;
import com.baidu.android.pushservice.i.a.b;
import com.baidu.android.pushservice.j.l;
import com.baidu.android.pushservice.j.m;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@TargetApi(21)
/* loaded from: classes.dex */
public class PushJobService extends JobService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Handler f3502a;

    /* loaded from: classes.dex */
    public static class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final JobService f3503a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(JobService jobService) {
            super(jobService.getMainLooper());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jobService};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f3503a = jobService;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && message.what == 1) {
                JobParameters jobParameters = (JobParameters) message.obj;
                try {
                    this.f3503a.jobFinished(jobParameters, true);
                    if (jobParameters.getJobId() == 1) {
                        com.baidu.android.pushservice.job.a.a(this.f3503a, false);
                    }
                } catch (Throwable th) {
                    new b.c(this.f3503a.getApplicationContext()).a(Log.getStackTraceString(th)).a();
                }
            }
        }
    }

    public PushJobService() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.onCreate();
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.onDestroy();
        }
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jobParameters)) == null) {
            if (m.p(getApplicationContext()) || !l.a(getApplicationContext(), null)) {
                try {
                    Intent a2 = f.a(getApplicationContext());
                    if (Build.VERSION.SDK_INT >= 28 && m.j()) {
                        a2.putExtra("disable_alarm", true);
                    }
                    g.a(getApplicationContext()).a(a2);
                } catch (Exception unused) {
                }
            }
            if (this.f3502a == null) {
                this.f3502a = new a(this);
            }
            Handler handler = this.f3502a;
            handler.sendMessageDelayed(Message.obtain(handler, 1, jobParameters), 2000L);
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jobParameters)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }
}
