package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.baidu.android.pushservice.i.m;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/* loaded from: classes5.dex */
public class CustomPushNotificationBuilder extends PushNotificationBuilder {
    private int mLayoutIconDrawable;
    private int mLayoutIconId;
    private int mLayoutId;
    private int mLayoutTextId;
    private int mLayoutTitleId;

    public CustomPushNotificationBuilder(int i, int i2, int i3, int i4) {
        this.mLayoutId = i;
        this.mLayoutIconId = i2;
        this.mLayoutTitleId = i3;
        this.mLayoutTextId = i4;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.mStatusbarIcon = objectInputStream.readInt();
        this.mNotificationFlags = objectInputStream.readInt();
        this.mNotificationDefaults = objectInputStream.readInt();
        if (objectInputStream.readBoolean()) {
            this.mNotificationsound = (String) objectInputStream.readObject();
        }
        int readInt = objectInputStream.readInt();
        this.mVibratePattern = new long[readInt];
        for (int i = 0; i < readInt; i++) {
            this.mVibratePattern[i] = objectInputStream.readLong();
        }
        this.mNotificationTitle = (String) objectInputStream.readObject();
        this.mNotificationText = (String) objectInputStream.readObject();
        this.mChannelId = (String) objectInputStream.readObject();
        this.mChannelName = (String) objectInputStream.readObject();
        this.mLayoutId = objectInputStream.readInt();
        this.mLayoutIconId = objectInputStream.readInt();
        this.mLayoutTitleId = objectInputStream.readInt();
        this.mLayoutTextId = objectInputStream.readInt();
        this.mLayoutIconDrawable = objectInputStream.readInt();
        this.mColor = objectInputStream.readInt();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.mStatusbarIcon);
        objectOutputStream.writeInt(this.mNotificationFlags);
        objectOutputStream.writeInt(this.mNotificationDefaults);
        if (this.mNotificationsound != null) {
            objectOutputStream.writeBoolean(true);
            objectOutputStream.writeObject(this.mNotificationsound);
        } else {
            objectOutputStream.writeBoolean(false);
        }
        if (this.mVibratePattern != null) {
            objectOutputStream.writeInt(this.mVibratePattern.length);
            for (int i = 0; i < this.mVibratePattern.length; i++) {
                objectOutputStream.writeLong(this.mVibratePattern[i]);
            }
        } else {
            objectOutputStream.writeInt(0);
        }
        objectOutputStream.writeObject(this.mNotificationTitle);
        objectOutputStream.writeObject(this.mNotificationText);
        objectOutputStream.writeObject(this.mChannelId);
        objectOutputStream.writeObject(this.mChannelName);
        objectOutputStream.writeInt(this.mLayoutId);
        objectOutputStream.writeInt(this.mLayoutIconId);
        objectOutputStream.writeInt(this.mLayoutTitleId);
        objectOutputStream.writeInt(this.mLayoutTextId);
        objectOutputStream.writeInt(this.mLayoutIconDrawable);
        objectOutputStream.writeInt(this.mColor);
    }

    @Override // com.baidu.android.pushservice.PushNotificationBuilder
    @SuppressLint({"NewApi"})
    public Notification construct(Context context) {
        Notification.Builder builder = new Notification.Builder(context);
        if (this.mNotificationDefaults != 0) {
            builder.setDefaults(this.mNotificationDefaults);
        }
        if (this.mNotificationsound != null) {
            builder.setSound(Uri.parse(this.mNotificationsound));
        }
        if (this.mVibratePattern != null) {
            builder.setVibrate(this.mVibratePattern);
        }
        if (this.mStatusbarIcon != 0) {
            builder.setSmallIcon(this.mStatusbarIcon);
        }
        if (this.mLayoutId != 0) {
            RemoteViews remoteViews = new RemoteViews(context.getPackageName(), this.mLayoutId);
            if (this.mLayoutIconDrawable != 0) {
                remoteViews.setImageViewResource(this.mLayoutIconId, this.mLayoutIconDrawable);
            }
            if (this.mNotificationTitle != null) {
                remoteViews.setTextViewText(this.mLayoutTitleId, this.mNotificationTitle);
            }
            if (this.mNotificationText != null) {
                remoteViews.setTextViewText(this.mLayoutTextId, this.mNotificationText);
            }
            builder.setContent(remoteViews);
        } else {
            builder.setContentTitle(this.mNotificationTitle);
            builder.setContentText(this.mNotificationText);
        }
        if (Build.VERSION.SDK_INT >= 21 && this.mColor != 0) {
            builder.setColor(this.mColor);
        }
        if (m.p(context)) {
            if (TextUtils.isEmpty(this.mChannelId)) {
                this.mChannelId = "com.baidu.android.pushservice.push";
            }
            if (TextUtils.isEmpty(this.mChannelName)) {
                this.mChannelName = "云推送";
            }
            com.baidu.android.pushservice.i.h.a(context, this.mChannelId, this.mChannelName);
            builder.setChannelId(this.mChannelId);
        }
        Notification build = Build.VERSION.SDK_INT >= 16 ? builder.build() : builder.getNotification();
        if (this.mNotificationFlags != 0 && build != null) {
            build.flags = this.mNotificationFlags;
        }
        return build;
    }

    public void setLayoutDrawable(int i) {
        this.mLayoutIconDrawable = i;
    }
}
