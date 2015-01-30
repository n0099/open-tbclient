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
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class NotificationHelper {
    private static NotificationCompat.Builder PROGRESS_BUILDER;

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

    public static boolean showNotification(Context context, int i, String str, String str2, String str3, PendingIntent pendingIntent, boolean z) {
        return showBaseNotification(context, i, str, str2, str3, pendingIntent, null, z);
    }

    public static synchronized boolean showProgressNotification(Context context, int i, String str, int i2, String str2, String str3, PendingIntent pendingIntent, boolean z) {
        boolean processNotification;
        synchronized (NotificationHelper.class) {
            PendingIntent activity = pendingIntent == null ? PendingIntent.getActivity(context, 0, new Intent(), 0) : pendingIntent;
            if (TbConfig.getAppRunMode() == TbConfig.AppRunMode.RUN_IN_KUANG_SDK) {
                processNotification = showNotification(context, i, str3, str3, str, activity, z);
            } else {
                if (PROGRESS_BUILDER == null) {
                    PROGRESS_BUILDER = new NotificationCompat.Builder(TbadkCoreApplication.m255getInst());
                }
                PROGRESS_BUILDER.setContentTitle(str3).setSmallIcon(17301633).setContentInfo(str2).setTicker(str).setProgress(100, i2, false).setLargeIcon(((BitmapDrawable) TbadkCoreApplication.m255getInst().getResources().getDrawable(com.baidu.tieba.v.icon)).getBitmap());
                Notification build = PROGRESS_BUILDER.build();
                build.contentIntent = activity;
                if (!z) {
                    build.flags = 16;
                } else {
                    build.flags = 2;
                }
                processNotification = processNotification(context, i, build);
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
        Notification notification;
        boolean z2;
        boolean z3;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        if (!com.baidu.tbadk.coreExtra.messageCenter.a.sa() && com.baidu.tbadk.coreExtra.messageCenter.a.rZ()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - TbadkCoreApplication.m255getInst().getLastNotifyTime() >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                boolean z7 = audioManager.getRingerMode() == 0;
                boolean z8 = audioManager.getRingerMode() == 1;
                if (TbadkCoreApplication.m255getInst().isMsgToneOn()) {
                    z4 = true;
                    if (z7 || z8) {
                        z4 = false;
                    }
                }
                if (!TbadkCoreApplication.m255getInst().isMsgVibrateOn()) {
                    z2 = false;
                } else {
                    if (!z7) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    z2 = z8 ? true : z3;
                }
                TbadkCoreApplication.m255getInst().setLastNotifyTime(currentTimeMillis);
                z5 = z2;
            }
        }
        if (TbadkCoreApplication.m255getInst().isMsgLightOn()) {
            z6 = true;
        }
        if (remoteViews != null) {
            notification = new Notification(com.baidu.tieba.v.icon, str3, System.currentTimeMillis());
            notification.icon = com.baidu.tieba.v.icon_notify;
            if (TextUtils.isEmpty(str)) {
                str = context.getString(com.baidu.tieba.z.app_name);
            }
            notification.setLatestEventInfo(context, str, str3, pendingIntent);
            notification.contentView = remoteViews;
        } else {
            if (TextUtils.isEmpty(str3)) {
                str3 = context.getString(com.baidu.tieba.z.notify_text);
            }
            notification = new Notification(com.baidu.tieba.v.icon_notify, str3, System.currentTimeMillis());
            cancelNotification(context, i);
            int i2 = 0;
            try {
                Field field = Class.forName("com.android.internal.R$id").getField("icon");
                field.setAccessible(true);
                i2 = field.getInt(null);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                notification = notif_excption(context);
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                notification = notif_excption(context);
            } catch (IllegalArgumentException e3) {
                e3.printStackTrace();
                notification = notif_excption(context);
            } catch (NoSuchFieldException e4) {
                e4.printStackTrace();
                notification = notif_excption(context);
            } catch (SecurityException e5) {
                e5.printStackTrace();
                notification = notif_excption(context);
            }
            if (bf.isEmpty(str)) {
                notification.setLatestEventInfo(context, context.getString(com.baidu.tieba.z.app_name), str2, pendingIntent);
            } else {
                notification.setLatestEventInfo(context, str, str2, pendingIntent);
            }
            if (i2 != 0 && notification.contentView != null) {
                notification.contentView.setImageViewResource(i2, com.baidu.tieba.v.icon);
            }
        }
        notification.defaults = -1;
        if (!z5) {
            notification.defaults &= -3;
        }
        if (!z4) {
            notification.defaults &= -2;
        }
        if (z) {
            notification.flags = 34;
        } else {
            notification.flags |= 16;
        }
        if (z6) {
            notification.defaults &= -5;
            notification.ledARGB = -16776961;
            notification.ledOnMS = 400;
            notification.ledOffMS = 700;
            notification.flags |= 1;
        }
        return processNotification(context, i, notification);
    }

    public static boolean showCustomViewNotification(Context context, int i, String str, String str2, PendingIntent pendingIntent, RemoteViews remoteViews, boolean z) {
        return showBaseNotification(context, i, str, null, str2, pendingIntent, remoteViews, z);
    }

    private static Notification notif_excption(Context context) {
        return new Notification(com.baidu.tieba.v.icon, context.getString(com.baidu.tieba.z.notify_text), System.currentTimeMillis());
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
}
