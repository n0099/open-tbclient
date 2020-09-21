package com.baidu.android.pushservice.job;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.android.pushservice.f;
import com.baidu.android.pushservice.g;
import com.baidu.android.pushservice.h.a.b;
import com.baidu.android.pushservice.i.l;
import com.baidu.android.pushservice.i.m;
@TargetApi(21)
/* loaded from: classes7.dex */
public class PushJobService extends JobService {
    private Handler a;

    /* loaded from: classes7.dex */
    private static class a extends Handler {
        private final JobService a;

        a(JobService jobService) {
            super(jobService.getMainLooper());
            this.a = jobService;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1) {
                JobParameters jobParameters = (JobParameters) message.obj;
                try {
                    this.a.jobFinished(jobParameters, true);
                    if (jobParameters.getJobId() == 1) {
                        com.baidu.android.pushservice.job.a.a(this.a, false);
                    }
                } catch (Throwable th) {
                    new b.c(this.a.getApplicationContext()).a(Log.getStackTraceString(th)).a();
                }
            }
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        if (m.p(getApplicationContext()) || !l.a(getApplicationContext(), null)) {
            try {
                Intent a2 = f.a(getApplicationContext());
                if (Build.VERSION.SDK_INT >= 28 && m.j()) {
                    a2.putExtra("disable_alarm", true);
                }
                g.a(getApplicationContext()).a(a2);
            } catch (Exception e) {
            }
        }
        if (this.a == null) {
            this.a = new a(this);
        }
        this.a.sendMessageDelayed(Message.obtain(this.a, 1, jobParameters), 2000L);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
