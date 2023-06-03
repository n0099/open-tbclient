package com.baidu.searchbox.downloads;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.RemoteViews;
import com.baidu.searchbox.download.ioc.IDownloadApp;
/* loaded from: classes3.dex */
public class VersionedNotification {
    public final Notification.Builder builder;

    public VersionedNotification(Context context) {
        this.builder = new Notification.Builder(context);
    }

    public static VersionedNotification getInstance(Context context) {
        return new VersionedNotification(context);
    }

    public void setAutoCancel(boolean z) {
        this.builder.setAutoCancel(z);
    }

    public void setChannel(String str) {
        IDownloadApp.Impl.get().setNotificationChannelAndGroupId(this.builder, str);
    }

    public void setContent(RemoteViews remoteViews) {
        this.builder.setContent(remoteViews);
    }

    public void setContentInfo(CharSequence charSequence) {
        this.builder.setContentInfo(charSequence);
    }

    public void setContentIntent(PendingIntent pendingIntent) {
        this.builder.setContentIntent(pendingIntent);
    }

    public void setContentText(CharSequence charSequence) {
        this.builder.setContentText(charSequence);
    }

    public void setContentTitle(CharSequence charSequence) {
        this.builder.setContentTitle(charSequence);
    }

    public void setDefaults(int i) {
        this.builder.setDefaults(i);
    }

    public void setDeleteIntent(PendingIntent pendingIntent) {
        this.builder.setDeleteIntent(pendingIntent);
    }

    public void setLargeIcon(Bitmap bitmap) {
        this.builder.setLargeIcon(bitmap);
    }

    public void setNumber(int i) {
        this.builder.setNumber(i);
    }

    public void setOngoing(boolean z) {
        this.builder.setOngoing(z);
    }

    public void setOnlyAlertOnce(boolean z) {
        this.builder.setOnlyAlertOnce(z);
    }

    public void setSmallIcon(int i) {
        this.builder.setSmallIcon(i);
    }

    public void setSound(Uri uri) {
        this.builder.setSound(uri);
    }

    public void setSubText(String str) {
        this.builder.setSubText(str);
    }

    public void setTicker(CharSequence charSequence) {
        this.builder.setTicker(charSequence);
    }

    public void setVibrate(long[] jArr) {
        this.builder.setVibrate(jArr);
    }

    public void setWhen(long j) {
        this.builder.setWhen(j);
    }

    public Notification getNotification() {
        return this.builder.getNotification();
    }

    public void setFullScreenIntent(PendingIntent pendingIntent, boolean z) {
        this.builder.setFullScreenIntent(pendingIntent, z);
    }

    public void setSmallIcon(int i, int i2) {
        this.builder.setSmallIcon(i, i2);
    }

    public void setSound(Uri uri, int i) {
        this.builder.setSound(uri, i);
    }

    public void setTicker(CharSequence charSequence, RemoteViews remoteViews) {
        this.builder.setTicker(charSequence, remoteViews);
    }

    public void setLights(int i, int i2, int i3) {
        this.builder.setLights(i, i2, i3);
    }

    public void setProgress(int i, int i2, boolean z) {
        this.builder.setProgress(i, i2, z);
    }
}
