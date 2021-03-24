package com.baidu.sofire.g;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.baidu.searchbox.elasticthread.statistic.StatisticRecorder;
import com.baidu.sofire.MyService;
import com.baidu.sofire.ac.U;
/* loaded from: classes3.dex */
public final class b {
    public static void a(Context context, int i, boolean z) {
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
            long j = 600000;
            if (i == 0) {
                j = StatisticRecorder.UPLOAD_DATA_TIME_THRESHOLD;
            } else if (i == 1) {
                j = 180000;
            } else if (i == 2) {
                j = 300000;
            }
            long currentTimeMillis = System.currentTimeMillis() + j;
            StringBuilder sb = new StringBuilder("n=");
            sb.append(currentTimeMillis);
            sb.append(", c=");
            sb.append(System.currentTimeMillis());
            com.baidu.sofire.b.a();
            alarmManager.cancel(service);
            if (z) {
                return;
            }
            alarmManager.set(1, currentTimeMillis, service);
        } catch (Throwable unused) {
            d.a();
        }
    }
}
