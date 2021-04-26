package com.baidu.mobads.sdk.api;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import d.a.f0.a;
import d.a.f0.b;
import d.a.f0.c;
/* loaded from: classes2.dex */
public class CustomNotification {
    public NotificationCompat.Style mStyle = new NotificationCompat.DecoratedCustomViewStyle();

    private void setRemoteViewText(RemoteViews remoteViews, int i2, String str) {
        if (remoteViews != null) {
            if (!TextUtils.isEmpty(str)) {
                remoteViews.setTextViewText(i2, str);
                remoteViews.setViewVisibility(i2, 0);
                return;
            }
            remoteViews.setViewVisibility(i2, 8);
        }
    }

    @TargetApi(16)
    public Notification getCustomNotification(Context context, String str, String str2, Bitmap bitmap, String str3, String str4, String str5, boolean z, int i2, int i3, String str6, PendingIntent pendingIntent) {
        NotificationCompat.Builder builder;
        if (Build.VERSION.SDK_INT < 26) {
            builder = new NotificationCompat.Builder(context);
        } else {
            if (TextUtils.isEmpty(str)) {
                str = "down";
            }
            try {
                builder = new NotificationCompat.Builder(context, str);
            } catch (NoSuchMethodError unused) {
                builder = new NotificationCompat.Builder(context);
            }
        }
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), c.mobads_cutom_notification_layout);
        if (bitmap != null) {
            remoteViews.setImageViewBitmap(b.left_icon, bitmap);
        } else {
            remoteViews.setImageViewResource(b.left_icon, a.ic_stat_bd_notif_download);
        }
        setRemoteViewText(remoteViews, b.notification_title, str3);
        if (TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5)) {
            remoteViews.setViewVisibility(b.content_layout, 8);
        } else {
            remoteViews.setViewVisibility(b.content_layout, 0);
            setRemoteViewText(remoteViews, b.content_text, str4);
            setRemoteViewText(remoteViews, b.content_status, str5);
        }
        if (i2 >= 0 && i2 <= 100) {
            remoteViews.setProgressBar(b.progress_bar, 100, i2, false);
            remoteViews.setViewVisibility(b.progress_bar, 0);
        } else {
            remoteViews.setViewVisibility(b.progress_bar, 8);
        }
        remoteViews.setTextViewText(b.btn_action, str6);
        remoteViews.setOnClickPendingIntent(b.btn_action, pendingIntent);
        return builder.setSmallIcon(i3).setOngoing(false).setTicker(str2).setAutoCancel(z).setWhen(System.currentTimeMillis()).setCustomContentView(remoteViews).build();
    }
}
