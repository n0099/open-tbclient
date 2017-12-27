package com.baidu.sofire;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import com.baidu.sofire.ac.Callback;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
@TargetApi(21)
/* loaded from: classes.dex */
public class PlatformJobService extends JobService {
    private static final ExecutorService a = Executors.newCachedThreadPool();

    @Override // android.app.job.JobService
    public boolean onStartJob(final JobParameters jobParameters) {
        try {
            new StringBuilder().append(jobParameters.getJobId());
            a.execute(new Runnable() { // from class: com.baidu.sofire.PlatformJobService.1
                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        com.baidu.sofire.core.c.aB(PlatformJobService.this.getApplicationContext()).a((Callback) null);
                    } catch (Throwable th) {
                        try {
                            com.baidu.sofire.b.d.a(th);
                        } finally {
                            PlatformJobService.this.jobFinished(jobParameters, false);
                        }
                    }
                }
            });
            return true;
        } catch (Throwable th) {
            com.baidu.sofire.b.d.a(th);
            return true;
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
