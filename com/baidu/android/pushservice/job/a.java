package com.baidu.android.pushservice.job;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.pushservice.h.a.b;
@TargetApi(21)
/* loaded from: classes10.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static C0069a f1162a;
    private static boolean b;

    /* renamed from: com.baidu.android.pushservice.job.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static class C0069a {

        /* renamed from: a  reason: collision with root package name */
        private final Context f1163a;
        private final JobScheduler b;
        private boolean c;

        C0069a(Context context) {
            this.f1163a = context;
            this.b = (JobScheduler) this.f1163a.getSystemService("jobscheduler");
        }

        private void a() {
            this.c = false;
            this.b.cancel(1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z) {
            if (z || this.c) {
                long j = 300000;
                if (z) {
                    a();
                    j = 300000 - (SystemClock.elapsedRealtime() % 300000);
                }
                this.c = true;
                JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.f1163a.getPackageName(), PushJobService.class.getName()));
                builder.setMinimumLatency(j);
                builder.setOverrideDeadline(j);
                builder.setRequiredNetworkType(1);
                builder.setPersisted(false);
                this.b.schedule(builder.build());
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            this.c = false;
            this.b.cancelAll();
        }
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            if (f1162a == null && Build.VERSION.SDK_INT >= 21) {
                try {
                    f1162a = new C0069a(context);
                } catch (Exception e) {
                    new b.c(context).a(Log.getStackTraceString(e)).a();
                }
            }
        }
    }

    public static synchronized void a(Context context, boolean z) {
        synchronized (a.class) {
            if (f1162a != null) {
                try {
                    b = true;
                    f1162a.a(z);
                } catch (Exception e) {
                    new b.c(context).a(Log.getStackTraceString(e)).a();
                }
            }
        }
    }

    public static boolean a() {
        return b;
    }

    public static synchronized void b(Context context) {
        synchronized (a.class) {
            if (f1162a != null) {
                try {
                    f1162a.b();
                } catch (Exception e) {
                    new b.c(context).a(Log.getStackTraceString(e)).a();
                }
                f1162a = null;
                b = false;
            }
        }
    }
}
