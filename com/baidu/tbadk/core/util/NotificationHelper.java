package com.baidu.tbadk.core.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.media.AudioManager;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.widget.RemoteViews;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class NotificationHelper {
    private static NotificationCompat.Builder PROGRESS_BUILDER;
    private static int lastProgressNotifiyId = 0;
    public static boolean IS_SUPPORT_PROGRESS_NOTIFICATION = true;

    public static boolean cancelNotification(Context context, int i) {
        if (context == null) {
            return false;
        }
        try {
            ((NotificationManager) context.getSystemService("notification")).cancel(i);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean cancelNotificationExceptSpecific(Context context, int i, int i2) {
        if (context == null || i == i2) {
            return false;
        }
        try {
            ((NotificationManager) context.getSystemService("notification")).cancel(i);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void cancelAllNotification(Context context) {
        if (context != null) {
            try {
                ((NotificationManager) context.getSystemService("notification")).cancelAll();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public static boolean showNotification(Context context, int i, String str, String str2, String str3, PendingIntent pendingIntent, boolean z) {
        return showBaseNotification(context, i, str, str2, str3, pendingIntent, null, z);
    }

    public static synchronized boolean showProgressNotification(Context context, int i, String str, int i2, String str2, String str3, PendingIntent pendingIntent, boolean z) {
        Notification notif_excption;
        boolean processNotification;
        synchronized (NotificationHelper.class) {
            PendingIntent activity = pendingIntent == null ? PendingIntent.getActivity(context, 0, new Intent(), 0) : pendingIntent;
            if (!IS_SUPPORT_PROGRESS_NOTIFICATION) {
                processNotification = showNotification(context, i, str3, str3, str, activity, z);
            } else {
                try {
                    if (PROGRESS_BUILDER == null) {
                        PROGRESS_BUILDER = new NotificationCompat.Builder(TbadkCoreApplication.m411getInst());
                    }
                    if (i != lastProgressNotifiyId) {
                        PROGRESS_BUILDER.setWhen(System.currentTimeMillis());
                    }
                    lastProgressNotifiyId = i;
                    PROGRESS_BUILDER.setContentTitle(str3).setSmallIcon(17301633).setContentInfo(str2).setTicker(str).setProgress(100, i2, false).setLargeIcon(((BitmapDrawable) TbadkCoreApplication.m411getInst().getResources().getDrawable(t.f.icon)).getBitmap());
                    PROGRESS_BUILDER.setContent(null);
                    notif_excption = PROGRESS_BUILDER.build();
                    notif_excption.contentIntent = activity;
                } catch (Exception e) {
                    notif_excption = notif_excption(context);
                }
                if (notif_excption == null) {
                    processNotification = false;
                } else {
                    if (!z) {
                        notif_excption.flags = 16;
                    } else {
                        notif_excption.flags = 2;
                    }
                    processNotification = processNotification(context, i, notif_excption);
                }
            }
        }
        return processNotification;
    }

    public static synchronized boolean showProgressNotification(Context context, int i, String str, int i2, String str2, String str3, boolean z) {
        boolean showProgressNotification;
        synchronized (NotificationHelper.class) {
            showProgressNotification = showProgressNotification(context, i, str, i2, str2, str3, null, z);
        }
        return showProgressNotification;
    }

    private static boolean showBaseNotification(Context context, int i, String str, String str2, String str3, PendingIntent pendingIntent, RemoteViews remoteViews, boolean z) {
        Notification notif_excption;
        if (pendingIntent == null) {
            pendingIntent = PendingIntent.getActivity(context, 0, new Intent(), 0);
        }
        a switchData = getSwitchData(context);
        if (switchData == null) {
            return false;
        }
        if (aw.isEmpty(str)) {
            str = context.getString(t.j.app_name);
        }
        try {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(TbadkCoreApplication.m411getInst());
            builder.setContentTitle(str).setContentText(str2).setSmallIcon(t.f.icon_notify).setTicker(str3);
            builder.setContent(remoteViews);
            notif_excption = builder.build();
            notif_excption.contentIntent = pendingIntent;
        } catch (Exception e) {
            notif_excption = notif_excption(context);
        }
        if (notif_excption != null) {
            notif_excption.defaults = -1;
            if (!switchData.ach) {
                notif_excption.defaults &= -3;
            }
            notif_excption.audioStreamType = 1;
            if (!switchData.acg) {
                notif_excption.defaults &= -2;
            }
            if (z) {
                notif_excption.flags = 34;
            } else {
                notif_excption.flags |= 16;
            }
            if (switchData.aci) {
                notif_excption.defaults &= -5;
                notif_excption.ledARGB = -16776961;
                notif_excption.ledOnMS = 400;
                notif_excption.ledOffMS = 700;
                notif_excption.flags |= 1;
            }
            return processNotification(context, i, notif_excption);
        }
        return false;
    }

    public static boolean showCustomViewNotification(Context context, int i, String str, String str2, PendingIntent pendingIntent, RemoteViews remoteViews, boolean z) {
        return showBaseNotification(context, i, str, null, str2, pendingIntent, remoteViews, z);
    }

    private static a getSwitchData(Context context) {
        a aVar = new a();
        if (!com.baidu.tbadk.coreExtra.messageCenter.a.yP() && com.baidu.tbadk.coreExtra.messageCenter.a.yO()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - TbadkCoreApplication.m411getInst().getLastNotifyTime() >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                boolean z = audioManager.getRingerMode() == 0;
                boolean z2 = audioManager.getRingerMode() == 1;
                if (com.baidu.tbadk.coreExtra.messageCenter.c.zk().zt()) {
                    aVar.acg = true;
                    if (z || z2) {
                        aVar.acg = false;
                    }
                }
                if (com.baidu.tbadk.coreExtra.messageCenter.c.zk().zw()) {
                    aVar.ach = true;
                    if (z) {
                        aVar.ach = false;
                    }
                    if (z2) {
                        aVar.ach = true;
                    }
                }
                TbadkCoreApplication.m411getInst().setLastNotifyTime(currentTimeMillis);
            }
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.c.zk().zu()) {
            aVar.aci = true;
        }
        return aVar;
    }

    private static Notification notif_excption(Context context) {
        return new Notification(t.f.icon, context.getString(t.j.notify_text), System.currentTimeMillis());
    }

    private static boolean processNotification(Context context, int i, Notification notification) {
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

    public static boolean canSupportClickPendingIntent() {
        return Build.VERSION.SDK_INT >= 11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        boolean acg = false;
        boolean ach = false;
        boolean aci = false;

        a() {
        }
    }
}
