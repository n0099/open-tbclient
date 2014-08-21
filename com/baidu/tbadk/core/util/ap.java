package com.baidu.tbadk.core.util;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public class ap {
    private static Notification a;
    private static MediaPlayer b;

    public static boolean a(Context context, int i) {
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

    public static boolean a(Context context, int i, String str, String str2, String str3, PendingIntent pendingIntent, boolean z) {
        return a(context, i, str, str2, str3, pendingIntent, null, z);
    }

    public static synchronized boolean a(Context context, int i, String str, int i2, String str2, String str3, boolean z) {
        boolean a2;
        synchronized (ap.class) {
            PendingIntent activity = PendingIntent.getActivity(context, 0, new Intent(), 0);
            if (a == null) {
                a = new Notification(17301633, str, System.currentTimeMillis());
                a.contentView = new RemoteViews(TbadkApplication.m252getInst().getPackageName(), com.baidu.tieba.v.notify_item);
            } else {
                a.tickerText = str;
            }
            a.contentView.setProgressBar(com.baidu.tieba.u.progress, 100, i2, false);
            a.contentView.setTextViewText(com.baidu.tieba.u.schedule, str2);
            a.contentView.setTextViewText(com.baidu.tieba.u.info, str3);
            a.contentIntent = activity;
            if (!z) {
                a.flags = 16;
            } else {
                a.flags = 2;
            }
            a2 = a(context, i, a, false);
        }
        return a2;
    }

    private static boolean a(Context context, int i, String str, String str2, String str3, PendingIntent pendingIntent, RemoteViews remoteViews, boolean z) {
        boolean z2;
        Notification notification;
        boolean z3;
        boolean z4 = false;
        boolean z5 = false;
        if (!com.baidu.tbadk.coreExtra.messageCenter.a.c() && com.baidu.tbadk.coreExtra.messageCenter.a.b()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - TbadkApplication.m252getInst().getLastNotifyTime() >= TbConfig.NOTIFY_SOUND_INTERVAL) {
                AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                boolean z6 = audioManager.getRingerMode() == 0;
                boolean z7 = audioManager.getRingerMode() == 1;
                if (TbadkApplication.m252getInst().isMsgToneOn()) {
                    z4 = true;
                    z4 = (z6 || z7) ? false : false;
                    if (audioManager.getStreamVolume(3) <= 0) {
                        z4 = false;
                    }
                }
                if (!TbadkApplication.m252getInst().isMsgVibrateOn()) {
                    z3 = false;
                } else {
                    z3 = true;
                    if (z6) {
                        z3 = false;
                    }
                    if (z7) {
                        z3 = true;
                    }
                }
                TbadkApplication.m252getInst().setLastNotifyTime(currentTimeMillis);
                z5 = z3;
            }
        }
        if (!TbadkApplication.m252getInst().isMsgLightOn()) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (remoteViews != null) {
            notification = new Notification(com.baidu.tieba.t.icon, str3, System.currentTimeMillis());
            notification.icon = com.baidu.tieba.t.icon_notify;
            if (TextUtils.isEmpty(str)) {
                str = context.getString(com.baidu.tieba.x.app_name);
            }
            notification.setLatestEventInfo(context, str, str3, pendingIntent);
            notification.contentView = remoteViews;
        } else {
            if (TextUtils.isEmpty(str3)) {
                str3 = context.getString(com.baidu.tieba.x.notify_text);
            }
            notification = new Notification(com.baidu.tieba.t.icon_notify, str3, System.currentTimeMillis());
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
            if (ba.c(str)) {
                notification.setLatestEventInfo(context, context.getString(com.baidu.tieba.x.app_name), str2, pendingIntent);
            } else {
                notification.setLatestEventInfo(context, str, str2, pendingIntent);
            }
            if (i2 != 0 && notification.contentView != null) {
                notification.contentView.setImageViewResource(i2, com.baidu.tieba.t.icon);
            }
        }
        notification.defaults = -1;
        notification.defaults &= -2;
        if (!z5) {
            notification.defaults &= -3;
        }
        if (z) {
            notification.flags = 34;
        } else {
            notification.flags |= 16;
        }
        if (z2) {
            notification.flags |= 1;
            notification.defaults |= 4;
        }
        return a(context, i, notification, z4);
    }

    public static boolean a(Context context, int i, String str, String str2, PendingIntent pendingIntent, RemoteViews remoteViews, boolean z) {
        return a(context, i, str, null, str2, pendingIntent, remoteViews, z);
    }

    private static Notification a(Context context) {
        return new Notification(com.baidu.tieba.t.icon, context.getString(com.baidu.tieba.x.notify_text), System.currentTimeMillis());
    }

    private static boolean a(Context context, int i, Notification notification, boolean z) {
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notification == null || notificationManager == null) {
                return false;
            }
            notificationManager.notify(i, notification);
            if (z) {
                b();
            }
            return true;
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    private static void b() {
        Uri defaultUri = RingtoneManager.getDefaultUri(2);
        if (defaultUri != null) {
            if (b == null) {
                synchronized (ap.class) {
                    if (b == null) {
                        b = new MediaPlayer();
                        b.setDataSource(TbadkApplication.m252getInst().getApplicationContext(), defaultUri);
                        b.setAudioStreamType(5);
                        b.setLooping(false);
                        b.setOnCompletionListener(new aq());
                    }
                }
            }
            if (!b.isPlaying()) {
                b.prepare();
                b.start();
            }
        }
    }

    public static boolean a() {
        return Build.VERSION.SDK_INT >= 11;
    }
}
