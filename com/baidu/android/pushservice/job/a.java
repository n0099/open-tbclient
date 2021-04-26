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
    public static C0057a f3480a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f3481b;

    /* renamed from: com.baidu.android.pushservice.job.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0057a {

        /* renamed from: a  reason: collision with root package name */
        public final Context f3482a;

        /* renamed from: b  reason: collision with root package name */
        public final JobScheduler f3483b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3484c;

        public C0057a(Context context) {
            this.f3482a = context;
            this.f3483b = (JobScheduler) context.getSystemService("jobscheduler");
        }

        private void a() {
            this.f3484c = false;
            this.f3483b.cancel(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z) {
            if (z || this.f3484c) {
                long j = 300000;
                if (z) {
                    a();
                    j = 300000 - (SystemClock.elapsedRealtime() % 300000);
                }
                this.f3484c = true;
                JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.f3482a.getPackageName(), PushJobService.class.getName()));
                builder.setMinimumLatency(j);
                builder.setOverrideDeadline(j);
                builder.setRequiredNetworkType(1);
                builder.setPersisted(false);
                this.f3483b.schedule(builder.build());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.f3484c = false;
            this.f3483b.cancelAll();
        }
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            if (f3480a == null && Build.VERSION.SDK_INT >= 21) {
                try {
                    f3480a = new C0057a(context);
                } catch (Exception e2) {
                    new b.c(context).a(Log.getStackTraceString(e2)).a();
                }
            }
        }
    }

    public static synchronized void a(Context context, boolean z) {
        synchronized (a.class) {
            if (f3480a != null) {
                try {
                    f3481b = true;
                    f3480a.a(z);
                } catch (Exception e2) {
                    new b.c(context).a(Log.getStackTraceString(e2)).a();
                }
            }
        }
    }

    public static boolean a() {
        return f3481b;
    }

    public static synchronized void b(Context context) {
        synchronized (a.class) {
            if (f3480a != null) {
                try {
                    f3480a.b();
                } catch (Exception e2) {
                    new b.c(context).a(Log.getStackTraceString(e2)).a();
                }
                f3480a = null;
                f3481b = false;
            }
        }
    }
}
