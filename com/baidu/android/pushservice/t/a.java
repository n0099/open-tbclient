package com.baidu.android.pushservice.t;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static volatile a d;
    public int a = -1;
    public int b = -1;
    public Context c;

    public a(Context context) {
        this.c = context;
    }

    public static a a(Context context) {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a(context);
                }
            }
        }
        return d;
    }

    public void a(int i) {
        if (this.b == -1 && a()) {
            this.b = i;
        }
    }

    public void a(Intent intent) {
        if (this.b == -1 && a()) {
            this.b = intent != null ? intent.getIntExtra("push_start_source", 0) : 0;
        }
    }

    public final boolean a() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        if (this.a < 0 && (runningAppProcesses = ((ActivityManager) this.c.getSystemService("activity")).getRunningAppProcesses()) != null && runningAppProcesses.size() > 0) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.processName.endsWith(":bdservice_v1")) {
                    this.a = next.pid;
                    break;
                }
            }
        }
        int i = this.a;
        return i > 0 && i == c();
    }

    public int b() {
        return this.b;
    }

    public final int c() {
        return Process.myPid();
    }
}
