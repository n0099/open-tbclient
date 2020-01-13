package com.baidu.sofire.i;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import com.baidu.sofire.MyService;
import com.baidu.sofire.ac.U;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
/* loaded from: classes5.dex */
public final class b {
    public static void a(Context context, int i, boolean z) {
        long j = KeepJobService.JOB_CHECK_PERIODIC;
        try {
            if (!"tvshield".equals("sofire")) {
                AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
                Intent intent = new Intent("com.baidu.action.SOFIRE.VIEW");
                intent.setClass(context, MyService.class);
                intent.setPackage(context.getPackageName());
                intent.addCategory("com.baidu.category.SOFIRE");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.putExtra("from_plugin_package", context.getPackageName());
                intent.putExtra("target_class", U.class.getCanonicalName());
                intent.putExtra("target_method", "handleWork");
                intent.putExtra("from", 2);
                PendingIntent service = PendingIntent.getService(context, 1001, intent, 134217728);
                switch (i) {
                    case 0:
                        j = 30000;
                        break;
                    case 1:
                        j = 180000;
                        break;
                    case 2:
                        j = 300000;
                        break;
                }
                long currentTimeMillis = j + System.currentTimeMillis();
                new StringBuilder("n=").append(currentTimeMillis).append(", c=").append(System.currentTimeMillis());
                com.baidu.sofire.b.a();
                alarmManager.cancel(service);
                if (!z) {
                    alarmManager.set(0, currentTimeMillis, service);
                }
            }
        } catch (Throwable th) {
            d.a();
        }
    }
}
