package com.baidu.android.pushservice.job;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import com.baidu.android.pushservice.a0.i;
import com.baidu.android.pushservice.a0.m;
import com.baidu.android.pushservice.e;
import com.baidu.android.pushservice.f;
import com.baidu.android.pushservice.util.Utility;
import com.baidu.android.pushservice.z.c;
@TargetApi(21)
/* loaded from: classes.dex */
public class PushJobService extends JobService {
    public Handler a;

    /* loaded from: classes.dex */
    public class a extends c {
        public final /* synthetic */ Intent c;

        public a(Intent intent) {
            this.c = intent;
        }

        @Override // com.baidu.android.pushservice.z.c
        public void a() {
            f.a(PushJobService.this.getApplicationContext()).a(this.c);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends Handler {
        public final JobService a;

        public b(JobService jobService) {
            super(jobService.getMainLooper());
            this.a = jobService;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                JobParameters jobParameters = (JobParameters) message.obj;
                try {
                    this.a.jobFinished(jobParameters, true);
                    int a = i.a(this.a.getApplicationContext(), "key_push_launch_task_level", 0);
                    if (jobParameters.getJobId() != 1 || a == 1) {
                        return;
                    }
                    com.baidu.android.pushservice.s.a.a(this.a, false);
                } catch (Throwable unused) {
                }
            }
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.baidu.android.pushservice.t.a.a(getApplicationContext()).a(0);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (Utility.E(getApplicationContext()) || !m.a(getApplicationContext(), (Intent) null)) {
            try {
                Intent j = e.j(getApplicationContext());
                if (Build.VERSION.SDK_INT >= 28 && Utility.Q(getApplicationContext())) {
                    j.putExtra("disable_alarm", true);
                }
                com.baidu.android.pushservice.z.e.a().a(new a(j));
            } catch (Exception unused) {
            }
        }
        if (this.a == null) {
            this.a = new b(this);
        }
        Handler handler = this.a;
        handler.sendMessageDelayed(Message.obtain(handler, 1, jobParameters), 2000L);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
