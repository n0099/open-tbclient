package com.baidu.android.pushservice.i;

import android.annotation.SuppressLint;
import android.app.AppOpsManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.support.v4.app.NotificationManagerCompat;
import com.baidu.android.util.io.ActionJsonData;
/* loaded from: classes7.dex */
public class h {
    @SuppressLint({"NewApi"})
    public static int a(Context context) {
        boolean z;
        int i = 1;
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                Class.forName(NotificationManagerCompat.class.getName()).getMethod("areNotificationsEnabled", new Class[0]);
                z = true;
            } catch (Throwable th) {
                z = false;
            }
            if (z) {
                try {
                    return NotificationManagerCompat.from(context).areNotificationsEnabled() ? 1 : 0;
                } catch (Exception e) {
                    return 2;
                }
            } else if (Build.VERSION.SDK_INT >= 28) {
                return 2;
            }
        }
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            String packageName = context.getApplicationContext().getPackageName();
            int i2 = applicationInfo.uid;
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            if (((Integer) cls.getMethod("checkOpNoThrow", Integer.TYPE, Integer.TYPE, String.class).invoke((AppOpsManager) context.getSystemService("appops"), Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i2), packageName)).intValue() != 0) {
                i = 0;
            }
        } catch (Throwable th2) {
            i = 2;
        }
        return i;
    }

    @SuppressLint({"NewApi"})
    public static void a(Context context, String str) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
        if (notificationManager != null) {
            notificationManager.deleteNotificationChannel(str);
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(Context context, String str, String str2) {
        NotificationChannel notificationChannel = new NotificationChannel(str, str2, 3);
        notificationChannel.setShowBadge(true);
        notificationChannel.setLockscreenVisibility(1);
        notificationChannel.enableVibration(false);
        notificationChannel.enableLights(false);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(notificationChannel);
        }
        i.a(context, "notification_channel_id", str);
    }
}
