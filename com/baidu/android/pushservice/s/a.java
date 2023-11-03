package com.baidu.android.pushservice.s;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.baidu.android.pushservice.job.PushJobService;
@TargetApi(21)
/* loaded from: classes.dex */
public class a {
    public static C0037a a;
    public static boolean b;

    /* renamed from: com.baidu.android.pushservice.s.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0037a {
        public final Context a;
        public final JobScheduler b;
        public boolean c;

        public C0037a(Context context) {
            this.a = context;
            this.b = (JobScheduler) context.getSystemService("jobscheduler");
        }

        public final void a() {
            this.c = false;
            this.b.cancel(1);
        }

        public final void a(boolean z) {
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
                this.b.schedule(builder.build());
            }
        }

        public final void b() {
            this.c = false;
            this.b.cancelAll();
        }
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            C0037a c0037a = a;
            if (c0037a != null) {
                try {
                    c0037a.b();
                } catch (Exception unused) {
                }
                a = null;
                b = false;
            }
        }
    }

    public static synchronized void a(Context context, boolean z) {
        synchronized (a.class) {
            C0037a c0037a = a;
            if (c0037a != null) {
                try {
                    b = true;
                    c0037a.a(z);
                } catch (Exception unused) {
                }
            }
        }
    }

    public static boolean a() {
        return b;
    }

    public static synchronized void b(Context context) {
        synchronized (a.class) {
            if (a == null && Build.VERSION.SDK_INT >= 21) {
                try {
                    a = new C0037a(context);
                } catch (Exception unused) {
                }
            }
        }
    }
}
