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
    public static C0056a f3481a;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f3482b;

    /* renamed from: com.baidu.android.pushservice.job.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0056a {

        /* renamed from: a  reason: collision with root package name */
        public final Context f3483a;

        /* renamed from: b  reason: collision with root package name */
        public final JobScheduler f3484b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f3485c;

        public C0056a(Context context) {
            this.f3483a = context;
            this.f3484b = (JobScheduler) context.getSystemService("jobscheduler");
        }

        private void a() {
            this.f3485c = false;
            this.f3484b.cancel(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z) {
            if (z || this.f3485c) {
                long j = 300000;
                if (z) {
                    a();
                    j = 300000 - (SystemClock.elapsedRealtime() % 300000);
                }
                this.f3485c = true;
                JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.f3483a.getPackageName(), PushJobService.class.getName()));
                builder.setMinimumLatency(j);
                builder.setOverrideDeadline(j);
                builder.setRequiredNetworkType(1);
                builder.setPersisted(false);
                this.f3484b.schedule(builder.build());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.f3485c = false;
            this.f3484b.cancelAll();
        }
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            if (f3481a == null && Build.VERSION.SDK_INT >= 21) {
                try {
                    f3481a = new C0056a(context);
                } catch (Exception e2) {
                    new b.c(context).a(Log.getStackTraceString(e2)).a();
                }
            }
        }
    }

    public static synchronized void a(Context context, boolean z) {
        synchronized (a.class) {
            if (f3481a != null) {
                try {
                    f3482b = true;
                    f3481a.a(z);
                } catch (Exception e2) {
                    new b.c(context).a(Log.getStackTraceString(e2)).a();
                }
            }
        }
    }

    public static boolean a() {
        return f3482b;
    }

    public static synchronized void b(Context context) {
        synchronized (a.class) {
            if (f3481a != null) {
                try {
                    f3481a.b();
                } catch (Exception e2) {
                    new b.c(context).a(Log.getStackTraceString(e2)).a();
                }
                f3481a = null;
                f3482b = false;
            }
        }
    }
}
