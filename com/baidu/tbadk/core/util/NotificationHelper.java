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
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.util.io.ActionJsonData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import d.a.c.e.q.h;
import d.a.m0.s.d.b;
import d.a.m0.s.d.d;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes3.dex */
public class NotificationHelper {
    public static boolean IS_SUPPORT_PROGRESS_NOTIFICATION = true;
    public static String PRIMARY_CHANNEL = "default";
    public static String PRIMARY_CHANNEL_2 = "default_2";
    public static String PRIMARY_CHANNEL_3 = "default_3";
    public static NotificationCompat.Builder PROGRESS_BUILDER;
    public static NotificationCompat.Builder PROGRESS_BUILDER_2;
    public static int lastProgressNotifiyId;

    /* loaded from: classes3.dex */
    public static class SwitchData {
        public boolean isSound = false;
        public boolean isVibrate = false;
        public boolean isLight = false;
    }

    public static boolean canSupportClickPendingIntent() {
        return Build.VERSION.SDK_INT >= 11;
    }

    public static void cancelAllNotification(Context context) {
        if (context == null) {
            return;
        }
        try {
            ((NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION)).cancelAll();
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public static boolean cancelNotification(Context context, int i2) {
        if (context == null) {
            return false;
        }
        try {
            ((NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION)).cancel(context.getPackageName(), i2);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean cancelNotificationExceptSpecific(Context context, int i2, int i3) {
        if (context != null && i2 != i3) {
            try {
                ((NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION)).cancel(context.getPackageName(), i2);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static Notification createNotificationByAPI(Context context, int i2, String str, int i3, String str2, String str3, PendingIntent pendingIntent, boolean z, RemoteViews remoteViews, boolean z2) {
        try {
            if (Build.VERSION.SDK_INT < 26) {
                if (PROGRESS_BUILDER == null) {
                    PROGRESS_BUILDER = new NotificationCompat.Builder(TbadkCoreApplication.getInst(), PRIMARY_CHANNEL);
                }
                if (i2 != lastProgressNotifiyId) {
                    PROGRESS_BUILDER.setWhen(System.currentTimeMillis());
                }
                lastProgressNotifiyId = i2;
                PROGRESS_BUILDER.setContentTitle(str3).setSmallIcon(17301633).setContentInfo(str2).setTicker(str).setProgress(100, i3, false).setLargeIcon(((BitmapDrawable) TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.tb_launcher_icon)).getBitmap());
                PROGRESS_BUILDER.setContent(remoteViews);
                Notification build = PROGRESS_BUILDER.build();
                build.contentIntent = pendingIntent;
                return build;
            }
            if (PROGRESS_BUILDER_2 == null) {
                PROGRESS_BUILDER_2 = new NotificationCompat.Builder(TbadkCoreApplication.getInst(), PRIMARY_CHANNEL_2);
            }
            if (i2 != lastProgressNotifiyId) {
                PROGRESS_BUILDER_2.setWhen(System.currentTimeMillis());
            }
            lastProgressNotifiyId = i2;
            PROGRESS_BUILDER_2.setContentTitle(str3).setSmallIcon(17301633).setContentInfo(str2).setTicker(str).setProgress(100, i3, false).setLargeIcon(((BitmapDrawable) TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.tb_launcher_icon)).getBitmap());
            PROGRESS_BUILDER_2.setContent(remoteViews);
            Notification build2 = PROGRESS_BUILDER_2.build();
            build2.contentIntent = pendingIntent;
            return build2;
        } catch (Exception unused) {
            return notif_excption(context);
        }
    }

    public static SwitchData getSwitchData(Context context) {
        SwitchData switchData = new SwitchData();
        if (!b.M() && b.R()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - TbadkCoreApplication.getInst().getLastNotifyTime() >= 5000) {
                AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
                boolean z = audioManager.getRingerMode() == 0;
                boolean z2 = audioManager.getRingerMode() == 1;
                if (d.d().u()) {
                    switchData.isSound = true;
                    if (z || z2) {
                        switchData.isSound = false;
                    }
                }
                if (d.d().v()) {
                    switchData.isVibrate = true;
                    if (z) {
                        switchData.isVibrate = false;
                    }
                    if (z2) {
                        switchData.isVibrate = true;
                    }
                }
                TbadkCoreApplication.getInst().setLastNotifyTime(currentTimeMillis);
            }
        }
        if (d.d().q()) {
            switchData.isLight = true;
        }
        return switchData;
    }

    public static Notification notif_excption(Context context) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, PRIMARY_CHANNEL);
        builder.setContentTitle(context.getString(R.string.notify_text));
        if (RomTypeUtil.isOnePlus()) {
            builder.setSmallIcon(R.drawable.tb_launcher_icon_notify_oneplus).setColor(ContextCompat.getColor(TbadkCoreApplication.getInst(), R.color.CAM_X0302));
        } else {
            builder.setSmallIcon(R.drawable.tb_launcher_icon_notify);
        }
        return builder.build();
    }

    public static boolean processNotification(Context context, int i2, Notification notification) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_2, h.a(R.string.notify_channel_primary), 3);
                notificationChannel.setLightColor(-16776961);
                notificationChannel.setLockscreenVisibility(0);
                notificationChannel.enableVibration(false);
                notificationChannel.setSound(null, null);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            if (notification == null || notificationManager == null) {
                return false;
            }
            notificationManager.notify(context.getPackageName(), i2, notification);
            return true;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public static void processNotificationIcon(NotificationCompat.Builder builder) {
        if (builder == null) {
            return;
        }
        if (RomTypeUtil.isOnePlus()) {
            builder.setSmallIcon(R.drawable.tb_launcher_icon_notify_oneplus).setColor(ContextCompat.getColor(TbadkCoreApplication.getInst(), R.color.CAM_X0302));
        } else {
            builder.setSmallIcon(R.drawable.tb_launcher_icon_notify);
        }
    }

    public static boolean processNotificationWithSoundAndVibration(Context context, int i2, Notification notification, SwitchData switchData) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(ActionJsonData.TAG_NOTIFICATION);
            if (Build.VERSION.SDK_INT >= 26) {
                NotificationChannel notificationChannel = new NotificationChannel(switchData.isSound ? PRIMARY_CHANNEL_3 : PRIMARY_CHANNEL_2, h.a(R.string.notify_channel_primary), 3);
                notificationChannel.setLightColor(-16776961);
                notificationChannel.setLockscreenVisibility(0);
                notificationChannel.enableVibration(switchData.isVibrate);
                if (!switchData.isSound) {
                    notificationChannel.setSound(null, null);
                }
                notificationChannel.enableLights(switchData.isLight);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            if (notification == null || notificationManager == null) {
                return false;
            }
            notificationManager.notify(context.getPackageName(), i2, notification);
            return true;
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public static boolean showBaseNotification(Context context, int i2, String str, String str2, String str3, PendingIntent pendingIntent, RemoteViews remoteViews, Bitmap bitmap, boolean z) {
        Notification notif_excption;
        NotificationCompat.Builder builder;
        if (pendingIntent == null) {
            pendingIntent = PendingIntent.getActivity(context, 0, new Intent(), 0);
        }
        SwitchData switchData = getSwitchData(context);
        if (switchData == null) {
            return false;
        }
        if (k.isEmpty(str)) {
            str = context.getString(R.string.app_name);
        }
        try {
            if (Build.VERSION.SDK_INT < 26) {
                builder = new NotificationCompat.Builder(TbadkCoreApplication.getInst(), PRIMARY_CHANNEL);
            } else {
                builder = new NotificationCompat.Builder(TbadkCoreApplication.getInst(), switchData.isSound ? PRIMARY_CHANNEL_3 : PRIMARY_CHANNEL_2);
            }
            builder.setContentTitle(str).setContentText(str2).setTicker(str3);
            processNotificationIcon(builder);
            if (bitmap != null) {
                builder.setLargeIcon(bitmap);
            }
            builder.setContent(remoteViews);
            notif_excption = builder.build();
            notif_excption.contentIntent = pendingIntent;
        } catch (Exception unused) {
            notif_excption = notif_excption(context);
        }
        if (notif_excption == null) {
            return false;
        }
        notif_excption.defaults = -1;
        if (!switchData.isVibrate) {
            notif_excption.defaults = (-1) & (-3);
        }
        notif_excption.audioStreamType = 1;
        if (!switchData.isSound) {
            notif_excption.defaults &= -2;
        }
        if (z) {
            notif_excption.flags = 34;
        } else {
            notif_excption.flags |= 16;
        }
        if (switchData.isLight) {
            notif_excption.defaults &= -5;
            notif_excption.ledARGB = -16776961;
            notif_excption.ledOnMS = 400;
            notif_excption.ledOffMS = 700;
            notif_excption.flags = 1 | notif_excption.flags;
        }
        return processNotificationWithSoundAndVibration(context, i2, notif_excption, switchData);
    }

    public static boolean showCustomViewNotification(Context context, int i2, String str, String str2, PendingIntent pendingIntent, RemoteViews remoteViews, boolean z) {
        return showBaseNotification(context, i2, str, null, str2, pendingIntent, remoteViews, null, z);
    }

    public static boolean showLargeIconNotification(Context context, int i2, String str, String str2, String str3, PendingIntent pendingIntent, Bitmap bitmap, boolean z) {
        return showBaseNotification(context, i2, str, str2, str3, pendingIntent, null, bitmap, z);
    }

    public static boolean showNotification(Context context, int i2, String str, String str2, String str3, PendingIntent pendingIntent, boolean z) {
        return showBaseNotification(context, i2, str, str2, str3, pendingIntent, null, null, z);
    }

    public static synchronized boolean showProgressNotification(Context context, int i2, String str, int i3, String str2, String str3, PendingIntent pendingIntent, boolean z) {
        boolean showProgressNotification;
        synchronized (NotificationHelper.class) {
            showProgressNotification = showProgressNotification(context, i2, str, i3, str2, str3, pendingIntent, z, null, true);
        }
        return showProgressNotification;
    }

    public static synchronized boolean showProgressNotification(Context context, int i2, String str, int i3, String str2, String str3, PendingIntent pendingIntent, boolean z, RemoteViews remoteViews, boolean z2) {
        synchronized (NotificationHelper.class) {
            PendingIntent activity = pendingIntent == null ? PendingIntent.getActivity(context, 0, new Intent(), 0) : pendingIntent;
            if (!IS_SUPPORT_PROGRESS_NOTIFICATION) {
                return showNotification(context, i2, str3, str3, str, activity, z);
            }
            Notification createNotificationByAPI = createNotificationByAPI(context, i2, str, i3, str2, str3, activity, z, remoteViews, z2);
            if (createNotificationByAPI == null) {
                return false;
            }
            if (z2) {
                if (!z) {
                    createNotificationByAPI.flags = 16;
                } else {
                    createNotificationByAPI.flags = 2;
                }
            }
            return processNotification(context, i2, createNotificationByAPI);
        }
    }

    public static synchronized boolean showProgressNotification(Context context, int i2, String str, int i3, String str2, String str3, boolean z) {
        boolean showProgressNotification;
        synchronized (NotificationHelper.class) {
            showProgressNotification = showProgressNotification(context, i2, str, i3, str2, str3, null, z);
        }
        return showProgressNotification;
    }
}
