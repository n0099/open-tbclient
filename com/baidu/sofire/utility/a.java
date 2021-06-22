package com.baidu.sofire.utility;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import com.baidu.sofire.MyService;
import com.baidu.sofire.ac.U;
/* loaded from: classes2.dex */
public final class a {
    public static void a(Context context, int i2, boolean z) {
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
            if (i2 == 0) {
                j = 30000;
            } else if (i2 == 1) {
                j = 180000;
            } else if (i2 == 2) {
                j = 300000;
            }
            long currentTimeMillis = System.currentTimeMillis() + j;
            try {
                alarmManager.cancel(service);
            } catch (Throwable unused) {
            }
            if (z) {
                return;
            }
            try {
                alarmManager.set(1, currentTimeMillis, service);
            } catch (Throwable unused2) {
            }
        } catch (Throwable unused3) {
            c.a();
        }
    }
}
