package com.baidu.sofire.rp.f;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
/* loaded from: classes.dex */
public final class a {
    public static void a(Context context, long j) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 101, new Intent("com.b.r.p"), 134217728);
        try {
            alarmManager.cancel(broadcast);
        } catch (Throwable th) {
            b.a();
        }
        try {
            alarmManager.set(0, System.currentTimeMillis() + j, broadcast);
        } catch (Exception e) {
            b.a();
        }
    }
}
