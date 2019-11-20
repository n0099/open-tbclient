package com.baidu.android.pushservice.job;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.baidu.android.pushservice.i.l;
@TargetApi(21)
/* loaded from: classes3.dex */
public class a {
    private static C0038a a;
    private static boolean b;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.android.pushservice.job.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0038a {
        private final Context a;
        private final JobScheduler b;
        private boolean c;

        C0038a(Context context) {
            this.a = context;
            this.b = (JobScheduler) this.a.getSystemService("jobscheduler");
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
                JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.a.getPackageName(), PushJobService.class.getName()));
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

    public static synchronized void a() {
        synchronized (a.class) {
            if (a != null) {
                try {
                    a.b();
                } catch (Exception e) {
                }
                a = null;
                b = false;
            }
        }
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            if (a == null && Build.VERSION.SDK_INT >= 21 && !l.E(context)) {
                try {
                    a = new C0038a(context);
                } catch (Exception e) {
                }
            }
        }
    }

    public static synchronized void a(boolean z) {
        synchronized (a.class) {
            if (a != null) {
                try {
                    b = true;
                    a.a(z);
                } catch (Exception e) {
                }
            }
        }
    }

    public static boolean b() {
        return b;
    }
}
