package com.baidu.android.pushservice;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.pushservice.i.m;
import com.baidu.browser.sailor.platform.BdSailorPlatform;
import com.baidu.webkit.internal.GlobalConstants;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/* loaded from: classes10.dex */
public class BasicPushNotificationBuilder extends PushNotificationBuilder {
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
        } else {
            int i = 0;
            if (context.getPackageName().equals(GlobalConstants.SEARCHBOX_PACKAGE_NAME) || context.getPackageName().equals(BdSailorPlatform.LITE_PACKAGE_NAME) || context.getPackageName().equals("com.baidu.push.qa")) {
                try {
                    i = context.getResources().getIdentifier(Build.VERSION.SDK_INT >= 21 ? "notification_icon_m" : "icon_statusbar", "drawable", context.getPackageName());
                } catch (Throwable th) {
                }
            }
            if (i == 0) {
                builder.setSmallIcon(context.getApplicationInfo().icon);
            } else {
                builder.setSmallIcon(i);
            }
        }
        builder.setContentTitle(this.mNotificationTitle);
        builder.setContentText(this.mNotificationText);
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
        if (build != null) {
            if (this.mNotificationFlags != 0) {
                build.flags = this.mNotificationFlags;
            } else {
                build.flags |= 16;
            }
        }
        return build;
    }
}
