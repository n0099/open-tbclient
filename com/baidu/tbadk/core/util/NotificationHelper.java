package com.baidu.tbadk.core.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.AudioManager;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.widget.RemoteViews;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.coloros.mcssdk.PushManager;
import com.vivo.push.util.NotifyAdapterUtil;
/* loaded from: classes.dex */
public class NotificationHelper {
    private static NotificationCompat.Builder PROGRESS_BUILDER;
    private static NotificationCompat.Builder PROGRESS_BUILDER_2;
    private static int lastProgressNotifiyId = 0;
    public static boolean IS_SUPPORT_PROGRESS_NOTIFICATION = true;
    private static String PRIMARY_CHANNEL = NotifyAdapterUtil.PRIMARY_CHANNEL;
    private static String PRIMARY_CHANNEL_2 = "default_2";
    private static String PRIMARY_CHANNEL_3 = "default_3";

    public static boolean cancelNotification(Context context, int i) {
        if (context == null) {
            return false;
        }
        try {
            ((NotificationManager) context.getSystemService(PushManager.MESSAGE_TYPE_NOTI)).cancel(context.getPackageName(), i);
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
            ((NotificationManager) context.getSystemService(PushManager.MESSAGE_TYPE_NOTI)).cancel(context.getPackageName(), i);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void cancelAllNotification(Context context) {
        if (context != null) {
            try {
                ((NotificationManager) context.getSystemService(PushManager.MESSAGE_TYPE_NOTI)).cancelAll();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
    }

    public static boolean showNotification(Context context, int i, String str, String str2, String str3, PendingIntent pendingIntent, boolean z) {
        return showBaseNotification(context, i, str, str2, str3, pendingIntent, null, null, z);
    }

    public static synchronized boolean showProgressNotification(Context context, int i, String str, int i2, String str2, String str3, PendingIntent pendingIntent, boolean z) {
        boolean showProgressNotification;
        synchronized (NotificationHelper.class) {
            showProgressNotification = showProgressNotification(context, i, str, i2, str2, str3, pendingIntent, z, null, true);
        }
        return showProgressNotification;
    }

    public static synchronized boolean showProgressNotification(Context context, int i, String str, int i2, String str2, String str3, PendingIntent pendingIntent, boolean z, RemoteViews remoteViews, boolean z2) {
        boolean processNotification;
        synchronized (NotificationHelper.class) {
            PendingIntent activity = pendingIntent == null ? PendingIntent.getActivity(context, 0, new Intent(), 0) : pendingIntent;
            if (!IS_SUPPORT_PROGRESS_NOTIFICATION) {
                processNotification = showNotification(context, i, str3, str3, str, activity, z);
            } else {
                Notification createNotificationByAPI = createNotificationByAPI(context, i, str, i2, str2, str3, activity, z, remoteViews, z2);
                if (createNotificationByAPI == null) {
                    processNotification = false;
                } else {
                    if (z2) {
                        if (!z) {
                            createNotificationByAPI.flags = 16;
                        } else {
                            createNotificationByAPI.flags = 2;
                        }
                    }
                    processNotification = processNotification(context, i, createNotificationByAPI);
                }
            }
        }
        return processNotification;
    }

    private static Notification createNotificationByAPI(Context context, int i, String str, int i2, String str2, String str3, PendingIntent pendingIntent, boolean z, RemoteViews remoteViews, boolean z2) {
        try {
            if (Build.VERSION.SDK_INT < 26) {
                if (PROGRESS_BUILDER == null) {
                    PROGRESS_BUILDER = new NotificationCompat.Builder(TbadkCoreApplication.getInst(), PRIMARY_CHANNEL);
                }
                if (i != lastProgressNotifiyId) {
                    PROGRESS_BUILDER.setWhen(System.currentTimeMillis());
                }
                lastProgressNotifiyId = i;
                PROGRESS_BUILDER.setContentTitle(str3).setSmallIcon(17301633).setContentInfo(str2).setTicker(str).setProgress(100, i2, false).setLargeIcon(((BitmapDrawable) TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon)).getBitmap());
                PROGRESS_BUILDER.setContent(remoteViews);
                Notification build = PROGRESS_BUILDER.build();
                build.contentIntent = pendingIntent;
                return build;
            }
            if (PROGRESS_BUILDER_2 == null) {
                PROGRESS_BUILDER_2 = new NotificationCompat.Builder(TbadkCoreApplication.getInst(), PRIMARY_CHANNEL_2);
            }
            if (i != lastProgressNotifiyId) {
                PROGRESS_BUILDER_2.setWhen(System.currentTimeMillis());
            }
            lastProgressNotifiyId = i;
            PROGRESS_BUILDER_2.setContentTitle(str3).setSmallIcon(17301633).setContentInfo(str2).setTicker(str).setProgress(100, i2, false).setLargeIcon(((BitmapDrawable) TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.icon)).getBitmap());
            PROGRESS_BUILDER_2.setContent(remoteViews);
            Notification build2 = PROGRESS_BUILDER_2.build();
            build2.contentIntent = pendingIntent;
            return build2;
        } catch (Exception e) {
            return notif_excption(context);
        }
    }

    public static synchronized boolean showProgressNotification(Context context, int i, String str, int i2, String str2, String str3, boolean z) {
        boolean showProgressNotification;
        synchronized (NotificationHelper.class) {
            showProgressNotification = showProgressNotification(context, i, str, i2, str2, str3, null, z);
        }
        return showProgressNotification;
    }

    private static boolean showBaseNotification(Context context, int i, String str, String str2, String str3, PendingIntent pendingIntent, RemoteViews remoteViews, Bitmap bitmap, boolean z) {
        Notification notif_excption;
        NotificationCompat.Builder builder;
        if (pendingIntent == null) {
            pendingIntent = PendingIntent.getActivity(context, 0, new Intent(), 0);
        }
        a switchData = getSwitchData(context);
        if (switchData == null) {
            return false;
        }
        if (ap.isEmpty(str)) {
            str = context.getString(R.string.app_name);
        }
        try {
            if (Build.VERSION.SDK_INT < 26) {
                builder = new NotificationCompat.Builder(TbadkCoreApplication.getInst(), PRIMARY_CHANNEL);
            } else {
                builder = new NotificationCompat.Builder(TbadkCoreApplication.getInst(), switchData.bRy ? PRIMARY_CHANNEL_3 : PRIMARY_CHANNEL_2);
            }
            builder.setContentTitle(str).setContentText(str2).setTicker(str3);
            processNotificationIcon(builder);
            if (bitmap != null) {
                builder.setLargeIcon(bitmap);
            }
            builder.setContent(remoteViews);
            notif_excption = builder.build();
            notif_excption.contentIntent = pendingIntent;
        } catch (Exception e) {
            notif_excption = notif_excption(context);
        }
        if (notif_excption != null) {
            notif_excption.defaults = -1;
            if (!switchData.bRz) {
                notif_excption.defaults &= -3;
            }
            notif_excption.audioStreamType = 1;
            if (!switchData.bRy) {
                notif_excption.defaults &= -2;
            }
            if (z) {
                notif_excption.flags = 34;
            } else {
                notif_excption.flags |= 16;
            }
            if (switchData.bRA) {
                notif_excption.defaults &= -5;
                notif_excption.ledARGB = -16776961;
                notif_excption.ledOnMS = 400;
                notif_excption.ledOffMS = 700;
                notif_excption.flags |= 1;
            }
            return processNotificationWithSoundAndVibration(context, i, notif_excption, switchData);
        }
        return false;
    }

    private static void processNotificationIcon(NotificationCompat.Builder builder) {
        if (builder != null) {
            if (com.baidu.tbadk.util.u.isEMUI()) {
                builder.setSmallIcon(R.drawable.icon_notify_blue);
            } else {
                builder.setSmallIcon(R.drawable.icon_notify);
            }
            builder.setColor(ContextCompat.getColor(TbadkCoreApplication.getInst(), R.color.cp_link_tip_a));
        }
    }

    public static boolean showCustomViewNotification(Context context, int i, String str, String str2, PendingIntent pendingIntent, RemoteViews remoteViews, boolean z) {
        return showBaseNotification(context, i, str, null, str2, pendingIntent, remoteViews, null, z);
    }

    public static boolean showLargeIconNotification(Context context, int i, String str, String str2, String str3, PendingIntent pendingIntent, Bitmap bitmap, boolean z) {
        return showBaseNotification(context, i, str, str2, str3, pendingIntent, null, bitmap, z);
    }

    private static a getSwitchData(Context context) {
        a aVar = new a();
        if (!com.baidu.tbadk.coreExtra.messageCenter.b.amA() && com.baidu.tbadk.coreExtra.messageCenter.b.amz()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - TbadkCoreApplication.getInst().getLastNotifyTime() >= 5000) {
                AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                boolean z = audioManager.getRingerMode() == 0;
                boolean z2 = audioManager.getRingerMode() == 1;
                if (com.baidu.tbadk.coreExtra.messageCenter.d.anf().ano()) {
                    aVar.bRy = true;
                    if (z || z2) {
                        aVar.bRy = false;
                    }
                }
                if (com.baidu.tbadk.coreExtra.messageCenter.d.anf().anr()) {
                    aVar.bRz = true;
                    if (z) {
                        aVar.bRz = false;
                    }
                    if (z2) {
                        aVar.bRz = true;
                    }
                }
                TbadkCoreApplication.getInst().setLastNotifyTime(currentTimeMillis);
            }
        }
        if (com.baidu.tbadk.coreExtra.messageCenter.d.anf().anp()) {
            aVar.bRA = true;
        }
        return aVar;
    }

    private static Notification notif_excption(Context context) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, PRIMARY_CHANNEL);
        builder.setContentTitle(context.getString(R.string.notify_text)).setSmallIcon(R.drawable.icon_notify).setColor(ContextCompat.getColor(context, R.color.cp_link_tip_a));
        return builder.build();
    }

    private static boolean processNotification(Context context, int i, Notification notification) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(PushManager.MESSAGE_TYPE_NOTI);
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_2, com.baidu.adp.lib.voice.h.getString(R.string.notify_channel_primary), 3);
                notificationChannel.setLightColor(-16776961);
                notificationChannel.setLockscreenVisibility(0);
                notificationChannel.enableVibration(false);
                notificationChannel.setSound(null, null);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            if (notification == null || notificationManager == null) {
                return false;
            }
            notificationManager.notify(context.getPackageName(), i, notification);
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    private static boolean processNotificationWithSoundAndVibration(Context context, int i, Notification notification, a aVar) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(PushManager.MESSAGE_TYPE_NOTI);
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel(aVar.bRy ? PRIMARY_CHANNEL_3 : PRIMARY_CHANNEL_2, com.baidu.adp.lib.voice.h.getString(R.string.notify_channel_primary), 3);
                notificationChannel.setLightColor(-16776961);
                notificationChannel.setLockscreenVisibility(0);
                notificationChannel.enableVibration(aVar.bRz);
                if (!aVar.bRy) {
                    notificationChannel.setSound(null, null);
                }
                notificationChannel.enableLights(aVar.bRA);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            if (notification == null || notificationManager == null) {
                return false;
            }
            notificationManager.notify(context.getPackageName(), i, notification);
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
        boolean bRy = false;
        boolean bRz = false;
        boolean bRA = false;

        a() {
        }
    }
}
