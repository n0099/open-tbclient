package com.baidu.tbadk.core.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import java.lang.reflect.Field;
import java.util.Date;
/* loaded from: classes.dex */
public class bb {
    private static Notification a;

    public static boolean a(Context context, int i) {
        if (i <= 0 || context == null) {
            return false;
        }
        try {
            ((NotificationManager) context.getSystemService("notification")).cancel(i);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean a(Context context, int i, String str, String str2, String str3, PendingIntent pendingIntent, boolean z) {
        return a(context, i, str, str2, str3, pendingIntent, null, z);
    }

    public static boolean a(Context context, int i, String str, int i2, String str2, String str3, boolean z) {
        PendingIntent activity = PendingIntent.getActivity(context, 0, new Intent(), 0);
        if (a == null) {
            a = new Notification(17301633, str, System.currentTimeMillis());
            a.contentView = new RemoteViews(TbadkApplication.m252getInst().getPackageName(), com.baidu.tieba.w.notify_item);
        } else {
            a.tickerText = str;
        }
        a.contentView.setProgressBar(com.baidu.tieba.v.progress, 100, i2, false);
        a.contentView.setTextViewText(com.baidu.tieba.v.schedule, str2);
        a.contentView.setTextViewText(com.baidu.tieba.v.info, str3);
        a.contentIntent = activity;
        if (!z) {
            a.flags = 16;
        } else {
            a.flags = 32;
        }
        return a(context, i, a);
    }

    private static boolean a(Context context, int i, String str, String str2, String str3, PendingIntent pendingIntent, RemoteViews remoteViews, boolean z) {
        boolean z2;
        boolean z3;
        Notification notification;
        if (!TbadkApplication.m252getInst().isPromotedMessageOn()) {
            return false;
        }
        boolean z4 = false;
        boolean z5 = false;
        long time = new Date().getTime();
        if (com.baidu.tbadk.coreExtra.messageCenter.a.b()) {
            z2 = false;
            z3 = false;
        } else {
            if (time - TbadkApplication.m252getInst().getLastNotifyTime() >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                if (TbadkApplication.m252getInst().isMsgToneOn()) {
                    z4 = true;
                }
                if (TbadkApplication.m252getInst().isMsgVibrateOn()) {
                    z5 = true;
                }
                TbadkApplication.m252getInst().setLastNotifyTime(time);
            }
            z2 = z5;
            z3 = z4;
        }
        if (remoteViews != null) {
            notification = new Notification(com.baidu.tieba.u.icon, str3, System.currentTimeMillis());
            notification.icon = com.baidu.tieba.u.icon_notify;
            if (TextUtils.isEmpty(str)) {
                str = context.getString(com.baidu.tieba.y.app_name);
            }
            notification.setLatestEventInfo(context, str, str3, pendingIntent);
            notification.contentView = remoteViews;
        } else {
            if (TextUtils.isEmpty(str3)) {
                str3 = context.getString(com.baidu.tieba.y.notify_text);
            }
            notification = new Notification(com.baidu.tieba.u.icon_notify, str3, System.currentTimeMillis());
            a(context, i);
            int i2 = 0;
            try {
                Field field = Class.forName("com.android.internal.R$id").getField("icon");
                field.setAccessible(true);
                i2 = field.getInt(null);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                notification = a(context);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                notification = a(context);
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                notification = a(context);
            } catch (NoSuchFieldException e4) {
                e4.printStackTrace();
                notification = a(context);
            } catch (SecurityException e5) {
                e5.printStackTrace();
                notification = a(context);
            }
            if (bm.c(str)) {
                notification.setLatestEventInfo(context, context.getString(com.baidu.tieba.y.app_name), str2, pendingIntent);
            } else {
                notification.setLatestEventInfo(context, str, str2, pendingIntent);
            }
            if (i2 != 0 && notification.contentView != null) {
                notification.contentView.setImageViewResource(i2, com.baidu.tieba.u.icon);
            }
        }
        notification.defaults = -1;
        if (!z2) {
            notification.defaults &= -3;
        }
        if (!z3) {
            notification.defaults &= -2;
        } else {
            notification.audioStreamType = 5;
        }
        if (z) {
            notification.flags = 34;
        } else {
            notification.flags |= 16;
        }
        return a(context, i, notification);
    }

    public static boolean a(Context context, int i, String str, String str2, PendingIntent pendingIntent, RemoteViews remoteViews, boolean z) {
        return a(context, i, str, null, str2, pendingIntent, remoteViews, z);
    }

    private static Notification a(Context context) {
        return new Notification(com.baidu.tieba.u.icon, context.getString(com.baidu.tieba.y.notify_text), System.currentTimeMillis());
    }

    private static boolean a(Context context, int i, Notification notification) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notification == null || notificationManager == null) {
                return false;
            }
            notificationManager.notify(i, notification);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 11;
    }
}
