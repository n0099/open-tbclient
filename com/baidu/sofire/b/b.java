package com.baidu.sofire.b;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import com.baidu.live.adp.lib.cache.BdKVCache;
import com.baidu.sofire.MyService;
import com.baidu.sofire.ac.U;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
import com.sina.weibo.sdk.statistic.StatisticConfig;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public final class b {
    public static void a(Context context, boolean z) {
        long currentTimeMillis;
        try {
            com.baidu.sofire.e eVar = new com.baidu.sofire.e(context);
            long t = BdKVCache.MILLS_1Hour * eVar.t();
            new StringBuilder("sjh-alarm gap ").append(eVar.t());
            com.baidu.sofire.b.a();
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
            if (!z) {
                currentTimeMillis = ((System.currentTimeMillis() + t) - KeepJobService.JOB_CHECK_PERIODIC) + ((long) (1200000.0d * Math.random()));
                eVar.a(currentTimeMillis);
            } else {
                currentTimeMillis = eVar.a.getLong("npuct", 0L);
                if (currentTimeMillis <= 0) {
                    currentTimeMillis = System.currentTimeMillis() + t;
                    eVar.a(currentTimeMillis);
                }
            }
            new StringBuilder("b=").append(z).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(currentTimeMillis).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(t).append(Constants.ACCEPT_TIME_SEPARATOR_SP).append(System.currentTimeMillis());
            com.baidu.sofire.b.a();
            alarmManager.cancel(service);
            alarmManager.set(0, currentTimeMillis, service);
        } catch (Throwable th) {
            e.a();
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
        } catch (Throwable th) {
            e.a();
        }
    }
}
