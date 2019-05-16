package com.baidu.android.pushservice.job;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.Handler;
import android.os.Message;
import com.baidu.android.pushservice.i.k;
import com.baidu.android.pushservice.i.l;
@TargetApi(21)
/* loaded from: classes3.dex */
public class PushJobService extends JobService {
    private Handler a;

    /* loaded from: classes3.dex */
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
                        com.baidu.android.pushservice.job.a.a(false);
                    }
                } catch (Throwable th) {
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
        if (l.E(this)) {
            return false;
        }
        k.d(this);
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
