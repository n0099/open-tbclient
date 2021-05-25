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
@TargetApi(21)
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static C0057a f3484a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f3485b;

    /* renamed from: com.baidu.android.pushservice.job.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0057a {

        /* renamed from: a  reason: collision with root package name */
        public final Context f3486a;

        /* renamed from: b  reason: collision with root package name */
        public final JobScheduler f3487b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3488c;

        public C0057a(Context context) {
            this.f3486a = context;
            this.f3487b = (JobScheduler) context.getSystemService("jobscheduler");
        }

        private void a() {
            this.f3488c = false;
            this.f3487b.cancel(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z) {
            if (z || this.f3488c) {
                long j = 300000;
                if (z) {
                    a();
                    j = 300000 - (SystemClock.elapsedRealtime() % 300000);
                }
                this.f3488c = true;
                JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.f3486a.getPackageName(), PushJobService.class.getName()));
                builder.setMinimumLatency(j);
                builder.setOverrideDeadline(j);
                builder.setRequiredNetworkType(1);
                builder.setPersisted(false);
                this.f3487b.schedule(builder.build());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.f3488c = false;
            this.f3487b.cancelAll();
        }
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            if (f3484a == null && Build.VERSION.SDK_INT >= 21) {
                try {
                    f3484a = new C0057a(context);
                } catch (Exception e2) {
                    new b.c(context).a(Log.getStackTraceString(e2)).a();
                }
            }
        }
    }

    public static synchronized void a(Context context, boolean z) {
        synchronized (a.class) {
            if (f3484a != null) {
                try {
                    f3485b = true;
                    f3484a.a(z);
                } catch (Exception e2) {
                    new b.c(context).a(Log.getStackTraceString(e2)).a();
                }
            }
        }
    }

    public static boolean a() {
        return f3485b;
    }

    public static synchronized void b(Context context) {
        synchronized (a.class) {
            if (f3484a != null) {
                try {
                    f3484a.b();
                } catch (Exception e2) {
                    new b.c(context).a(Log.getStackTraceString(e2)).a();
                }
                f3484a = null;
                f3485b = false;
            }
        }
    }
}
