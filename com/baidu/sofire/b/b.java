package com.baidu.sofire.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import com.baidu.sofire.MyService;
import com.baidu.sofire.ac.U;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.baidu.tieba.model.ReportUserInfoModel;
import com.sina.weibo.sdk.statistic.StatisticConfig;
/* loaded from: classes.dex */
public class b {
    public static void a(Context context, boolean z) {
        long currentTimeMillis;
        try {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            long I = 3600000 * eVar.I();
            com.baidu.sofire.b.a("sjh-alarm gap " + eVar.I());
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            Intent intent = new Intent("com.baidu.action.SOFIRE.VIEW");
            intent.setClass(context, MyService.class);
            intent.setPackage(context.getPackageName());
            intent.addCategory("com.baidu.category.SOFIRE");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra("from_plugin_package", context.getPackageName());
            intent.putExtra("target_class", U.class.getCanonicalName());
            intent.putExtra("target_method", "handleWork");
            intent.putExtra("from", 6);
            PendingIntent service = PendingIntent.getService(context, 1000, intent, 134217728);
            if (z) {
                currentTimeMillis = eVar.a();
                if (currentTimeMillis <= 0) {
                    currentTimeMillis = System.currentTimeMillis() + I;
                    eVar.a(currentTimeMillis);
                }
            } else {
                currentTimeMillis = ((System.currentTimeMillis() + I) - KeepJobService.JOB_CHECK_PERIODIC) + ((long) (1200000.0d * Math.random()));
                eVar.a(currentTimeMillis);
            }
            com.baidu.sofire.b.a("b=" + z + ", n=" + currentTimeMillis + ", t=" + I + ", c=" + System.currentTimeMillis());
            alarmManager.cancel(service);
            alarmManager.set(0, currentTimeMillis, service);
        } catch (Throwable th) {
            e.a(th);
        }
    }

    public static void a(Context context, int i, boolean z) {
        long j = KeepJobService.JOB_CHECK_PERIODIC;
        try {
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
                    j = StatisticConfig.MIN_UPLOAD_INTERVAL;
                    break;
                case 1:
                    j = 180000;
                    break;
                case 2:
                    j = ReportUserInfoModel.TIME_INTERVAL;
                    break;
            }
            long currentTimeMillis = j + System.currentTimeMillis();
            com.baidu.sofire.b.a("n=" + currentTimeMillis + ", c=" + System.currentTimeMillis());
            alarmManager.cancel(service);
            if (!z) {
                alarmManager.set(0, currentTimeMillis, service);
            }
        } catch (Throwable th) {
            e.a(th);
        }
    }
}
